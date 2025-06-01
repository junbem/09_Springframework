package com.ohgiraffers.practice.employee.model.service;

import com.ohgiraffers.practice.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.practice.employee.model.dto.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.practice.common.Template.getSqlSession;

public class EmployeeService {

    public static List<EmployeeDTO> selectAllMember() {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<EmployeeDTO> memberList = employeeMapper.selectAllMember();

        sqlSession.close();

        return memberList;
    }

    public boolean insertMember(EmployeeDTO employee) {
        SqlSession sqlSession = getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        int result = employeeMapper.insertMember(employee);

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }
}
