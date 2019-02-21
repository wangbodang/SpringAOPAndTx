package com.wangbodang.employee.service.impl;

import com.wangbodang.employee.entity.Employee;
import com.wangbodang.employee.mapper.EmployeeMapper;
import com.wangbodang.employee.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void printAString() {
        System.out.println("---> print a String. method : DemoService.printAString \2\2");
    }

    @Override
    public void printListFromDataSource() {
        try {
            Connection conn = dataSource.getConnection();
            Statement smt = conn.createStatement();
            String sql = "select * from employee";
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("--->"+id+", "+name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printListFromSqlSession() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = employeeMapper.findAll();
        for(Employee e:employeeList){
            System.out.println(e);
        }
    }

    @Override
    public void printListFromEmployeeMapper() {
        List<Employee> employeeList = employeeMapper.findAll();
        for(Employee e:employeeList){
            System.out.println(e);
        }
    }
}

