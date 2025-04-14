package com.example.hms2;

// package com.example.hms2;

public class OUEmailPasswordRequest {
    private String email;
    private String password;

    public OUEmailPasswordRequest() {}

    public OUEmailPasswordRequest(String email, String password) {
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
