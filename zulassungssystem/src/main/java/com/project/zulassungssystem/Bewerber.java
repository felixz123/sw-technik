package com.project.zulassungssystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bewerber {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "bewerber")
    private User user;

    private Status status;

    private String content;

    private String abschluss;

    private String durchschnitt;

    protected Bewerber() {}

    public Bewerber(Status status, String content) {
        this.status = status;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Status getStatus() {
        return status;
    }

    public String getContent() {
        return content;
    }

    public String getAbschluss() {
        return abschluss;
    }

    public String getDurchschnitt() {
        return durchschnitt;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAbschluss(String abschluss) {
        this.abschluss = abschluss;
    }

    public void setDurchschnitt(String durchschnitt) {
        this.durchschnitt = durchschnitt;
    }
} 
