package com.project.zulassungssystem;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Roles role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_bewerber", 
      joinColumns = 
        { @JoinColumn(name = "user_id", referencedColumnName = "id") },
      inverseJoinColumns = 
        { @JoinColumn(name = "bewerber_id", referencedColumnName = "id") })
    private Bewerber bewerber;

    protected User() {}

    public User(String firstName, String lastName, String email, Roles role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.bewerber = new Bewerber(Status.NICHT_EINGEREICHT, "");
    }

    @Override
    public String toString() {
        return String.format(
            "User[id=%d, firstName='%s', lastName='%s']",
            id, firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Roles getRole() {
        return role;
    }

    public Bewerber getBewerber() {
        return bewerber;
    }

    public void setBewerber(Bewerber bewerber) {
        this.bewerber = bewerber;
    }
}