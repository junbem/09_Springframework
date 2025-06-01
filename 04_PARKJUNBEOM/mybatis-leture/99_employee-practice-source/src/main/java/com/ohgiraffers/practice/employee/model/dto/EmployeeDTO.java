package com.ohgiraffers.practice.employee.model.dto;

public class EmployeeDTO {

    private int emp_id;
    private String emp_name;
    private String emp_no;
    private String emp_email;
    private String emp_phone;

    public EmployeeDTO() {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_no = emp_no;
        this.emp_email = emp_email;
        this.emp_phone = emp_phone;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_no=" + emp_no +
                ", emp_email='" + emp_email + '\'' +
                ", emp_phone='" + emp_phone + '\'' +
                '}';
    }
}
