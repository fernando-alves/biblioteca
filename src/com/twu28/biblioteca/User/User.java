package com.twu28.biblioteca.user;

public class User {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;

    public User(String username, String password, String email, String phone,
                String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public boolean isCorrectPassword(String password) {
        return this.password.compareTo(password) == 0;
    }
}
