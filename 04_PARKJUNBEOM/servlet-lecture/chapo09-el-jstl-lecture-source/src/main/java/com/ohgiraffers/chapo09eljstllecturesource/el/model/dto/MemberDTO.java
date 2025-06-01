package com.ohgiraffers.chapo09eljstllecturesource.el.model.dto;

public class MemberDTO {

    private String naem;
    private int age;
    private String phone;
    private String email;

    public MemberDTO(String naem, int age, String phone, String email) {
        this.naem = naem;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
