package com.ohgiraffers.practice.employee.controller;

import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.practice.employee.model.service.EmployeeService;
import com.ohgiraffers.practice.employee.printResult.PrintResult;

import java.util.List;
import java.util.Map;

public class EmployeeController {

    private final EmployeeService employeeService;
    private final PrintResult printResult;


    public EmployeeController() {
        this.employeeService = new EmployeeService();
        this.printResult = new PrintResult();
    }

    public void selectAllMember() {
        List<EmployeeDTO> employeeList = employeeService.selectAllMember();
        if(employeeList != null && !employeeList.isEmpty()){
            printResult.printEmployeeList(employeeList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectMember() {
        
    }

    public void insertMember(Map<String, String> parameter) {

        EmployeeDTO employee = new EmployeeDTO();
        employee.setEmp_id(Integer.parseInt(parameter.get("emp_id")));
        employee.setEmp_name(parameter.get("emp_name"));
        employee.setEmp_no(parameter.get("emp_no"));

        if(employeeService.insertMember(employee)) {
            printResult.printSuccessMessage("insertMember");
        } else {
            printResult.printErrorMessage("insertMember");
        }
    }
}