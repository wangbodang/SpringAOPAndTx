package com.wangbodang.demo.service;

import com.wangbodang.demo.entity.Foo;
import common.web.ResultException;

public interface FooService {
    Foo getFoo(String fooName);
    Foo getFoo(String fooName, String barName);
    void insertFoo(Foo foo) throws ResultException;
    void updateFoo(Foo foo) throws Exception;
}
