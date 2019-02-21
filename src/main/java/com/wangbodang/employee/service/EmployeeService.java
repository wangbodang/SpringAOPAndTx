package com.wangbodang.employee.service;

public interface EmployeeService {
    void printAString();

    /**
     * 用DataSource读取数据库
     */
    void printListFromDataSource();
    /**
     * 用sqlSession查询
     */
    void printListFromSqlSession();

    /**
     * 用employeeMapper查询
     */
    void printListFromEmployeeMapper();
}
