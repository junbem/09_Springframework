package com.ohgiraffers.practice.employee.view;

import com.ohgiraffers.practice.employee.controller.EmployeeController;
import com.ohgiraffers.practice.employee.model.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeController employeeController = new EmployeeController();

        while(true) {
            System.out.println("===== 회원 관리 ======");
            System.out.println("1. 회원 전체 조회");
            System.out.println("2. 회원 코드로 메뉴 조회");
            System.out.println("3. 회원 추가");
            System.out.println("4. 회원 수정");
            System.out.println("5. 회원 삭제");
            System.out.println("9. 종료하기");
            System.out.print("회원 관리 번호 입력 : ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    employeeController.selectAllMember();
                    break;
                case 2:
                    employeeController.selectMember();
                    break;
                case 3:
                    employeeController.insertMember(inputMember());
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 9:
                    return;
                default:
                    System.out.println("잘못된 번호를 선택하셨습니다.");
            }
        }
    }

    private static Map<String, String> inputMember() {

        Scanner sc = new Scanner(System.in);
        System.out.print("회원 아이디를 입력하세요 : ");
        String emp_id = sc.nextLine();
        System.out.print("회원 이름을 입력하세요 : ");
        String emp_name = sc.nextLine();
        System.out.print("회원 주민번호을 입력하세요 : ");
        String emp_no = sc.nextLine();
        Map<String, String> parameter = new HashMap<>();
        parameter.put("emp_id", emp_id);
        parameter.put("emp_name", emp_name);
        parameter.put("emp_no", emp_no);
        return parameter;
    }
}