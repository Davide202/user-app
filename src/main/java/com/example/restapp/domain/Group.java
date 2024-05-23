package com.example.restapp.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GROUP-USER",schema = "auth")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description" , unique = true)
    private String description;

    @OneToMany(mappedBy = "group")
    @JsonIgnore
    Set<User> userList;

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public Set<User> getUserList() {return userList;}
    public void setUserList(Set<User> userList) {this.userList = userList;}
}
