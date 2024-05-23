package com.example.restapp.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "USER",schema = "auth")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "NOTES")
    private String notes;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "ID_GROUP")
    private Group group;

    public User(){
        this.firstName = "Davide";this.lastName = "D'Innocente";
    }
    public User(String name, String surname){
        this.firstName = name;this.lastName = surname;
    }

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Group getGroup() {return group;}
    public void setGroup(Group group) {this.group = group;}
    public String getNotes() {return notes;}
    public void setNotes(String notes) {this.notes = notes;}
}