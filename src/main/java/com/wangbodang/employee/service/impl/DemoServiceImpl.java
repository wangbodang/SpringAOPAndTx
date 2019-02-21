package com.wangbodang.employee.service.impl;

import com.wangbodang.employee.entity.Employee;
import com.wangbodang.employee.mapper.EmployeeMapper;
import com.wangbodang.employee.service.DemoService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

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
}

