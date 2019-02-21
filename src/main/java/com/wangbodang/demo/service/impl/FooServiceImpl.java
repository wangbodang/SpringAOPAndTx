package com.wangbodang.demo.service.impl;

import com.wangbodang.demo.entity.Foo;
import com.wangbodang.demo.service.FooService;
import com.wangbodang.employee.entity.Employee;
import com.wangbodang.employee.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("fooService")
public class FooServiceImpl implements FooService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Foo getFoo(String fooName) {
        throw new UnsupportedOperationException();
    }
    public Foo getFoo(String fooName, String barName) {
        throw new UnsupportedOperationException();
    }
    public void insertFoo(Foo foo){

            Employee employee = new Employee();
            employee.setName("李世民");
            employee.setAge(35);
            employee.setGender(1);
            employeeMapper.insert(employee);
            //"23".charAt(34);
    }
    public void updateFoo(Foo foo) {

        Employee employee = new Employee();
        employee.setId(11010);
        employee.setName("李世民");
        employee.setHiredate(new Date());
        employeeMapper.updateByPrimaryKeySelective(employee);
    }
}
