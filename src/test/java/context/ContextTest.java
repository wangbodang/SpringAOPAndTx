package context;

import com.wangbodang.employee.service.DemoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextTest {

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
    public void testSprintContext(){
        DemoService demoService = (DemoService) ctx.getBean("demoService");
        demoService.printAString();
    }

    @Test
    public void testDataSourceFromCtx(){
        DemoService demoService = (DemoService) ctx.getBean("demoService");
        demoService.printListFromDataSource();
    }
    @Test
    public void testSqlSessionFromCtx(){
        DemoService demoService = (DemoService) ctx.getBean("demoService");
        demoService.printListFromSqlSession();
    }
}
