package com.example.restapp;

import com.example.restapp.domain.Group;
import com.example.restapp.domain.User;
import com.example.restapp.repo.GroupRepository;
import com.example.restapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class CController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Value("${info.value}")
    private String value;

    // http://localhost:80/info
    @GetMapping({"","/info"}) public ResponseEntity<?> getValue(){return ResponseEntity.ok(value);}

    @GetMapping("/users") public ResponseEntity<?> getAll(
            @RequestParam(value = "name",required = false,defaultValue = "")String name
    ){
        List<User> all = (List<User>) userRepository.findAll();
        if (!"".equals(name)) {
        return ResponseEntity.ok(all.stream()
                .filter(user -> user.getFirstName().toUpperCase().contains(name.toUpperCase())).toList());
        }
        return ResponseEntity.ok(all);
    }
    @GetMapping("/user/{id}") public ResponseEntity<?> getById(
            @PathVariable("id")Long id
    ){
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @PostMapping("/user")
    public ResponseEntity<?> insert(@RequestBody User user){
        user.setGroup(getGroup(user));
        return ResponseEntity.ok(userRepository.save(user));
    }
    @PostMapping("/users")
    public ResponseEntity<?> insertMany(@RequestBody List<User> users){
        for (User user : users) user.setGroup(getGroup(user));
        return ResponseEntity.ok(userRepository.saveAll(users));
    }

    private Group getGroup(User user){
        Group group = groupRepository.findByDescription(user.getGroup().getDescription());
        if (group == null){
            group = groupRepository.save(user.getGroup());
        }
        return group;
    }
}
