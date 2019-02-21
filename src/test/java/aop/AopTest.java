package aop;

import com.wangbodang.demo.service.FooService;
import com.wangbodang.employee.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    private ApplicationContext ctx;

    /**
     * load and close spring context
     */
    @Before
    public void init(){
        String ctxConfig = "conf/appCtx.xml";
        ctx = new ClassPathXmlApplicationContext(ctxConfig);
    }
    @After
    public void destory(){
        ((AbstractApplicationContext)ctx).close();
    }

    @Test
    public void testEmpMapperFromCtx(){
        EmployeeService demoService = (EmployeeService) ctx.getBean("demoService");
        demoService.printListFromEmployeeMapper();
    }

    @Test
    public void testAop(){
        FooService fooService = (FooService) ctx.getBean("fooService");
        fooService.getFoo("fook");
    }

}
