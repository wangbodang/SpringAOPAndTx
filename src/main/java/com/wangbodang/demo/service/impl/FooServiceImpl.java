package com.wangbodang.demo.service.impl;

import com.wangbodang.demo.entity.Foo;
import com.wangbodang.demo.service.FooService;
import org.springframework.stereotype.Service;

@Service("fooService")
public class FooServiceImpl implements FooService {
    public Foo getFoo(String fooName) {
        throw new UnsupportedOperationException();
    }
    public Foo getFoo(String fooName, String barName) {
        throw new UnsupportedOperationException();
    }
    public void insertFoo(Foo foo) {
        throw new UnsupportedOperationException();
    }
    public void updateFoo(Foo foo) {
        throw new UnsupportedOperationException();
    }
}
