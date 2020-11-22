package com.project.zulassungssystem;



public class UserBewerberModel {
    
    private String firstName;

    private String lastName;

    private String email;

    private String status;

    private String content;

    private String abschluss;

    private String durchschnitt;

    public UserBewerberModel() {}

    public UserBewerberModel(String firstName, String lastName, String email, Status status, String content) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status.toString();
        this.content = content;
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

    public String getStatus() {
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
}
