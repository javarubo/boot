package com.example.demo.model.dto;




public class VerifyRequestDto {
    private String email;
    private String code;





    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "VerifyRequestDto{" +
                "email='" + email + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public void setCode(String code) {
        this.code = code;



    }
}
