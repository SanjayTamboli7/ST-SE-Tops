package com.example.hms2;

//package com.example.demo.dto;

//package com.example.demo.dto;

public class OUChangePasswordRequest {
    private String email;
    private String password;

    public OUChangePasswordRequest() {}

    public OUChangePasswordRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

