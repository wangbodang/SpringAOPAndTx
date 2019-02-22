package com.wangbodang.demo.service.impl;

import com.wangbodang.demo.entity.Foo;
import com.wangbodang.demo.service.FooService;
import com.wangbodang.employee.entity.Employee;
import com.wangbodang.employee.mapper.EmployeeMapper;
import common.web.RemoteResult;
import common.web.ResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public void insertFoo(Foo foo) throws ResultException {
        RemoteResult<String> remoteResult = new RemoteResult<>(false);
        try {
            Employee employee = new Employee();
            employee.setName("李世民");
            employee.setAge(35);
            employee.setGender(1);
            employeeMapper.insert(employee);
            //"23".charAt(34);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("--->insert 业务层捕获异常 消息:"+e.getMessage());
            throw new ResultException(remoteResult);
        }
    }
    public void updateFoo(Foo foo){


            Employee employee = new Employee();
            employee.setId(11012);
            employee.setName("李世民");
            employee.setSalary(new BigDecimal("77878.23"));
            employee.setHiredate(new Date());
            employeeMapper.updateByPrimaryKeySelective(employee);
            "23".charAt(34);
    }
}
