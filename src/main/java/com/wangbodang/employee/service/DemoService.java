package com.wangbodang.employee.service;

public interface DemoService {
    void printAString();

    /**
     * 用DataSource读取数据库
     */
    void printListFromDataSource();
    /**
     * 用sqlSession查询
     */
    void printListFromSqlSession();
}
