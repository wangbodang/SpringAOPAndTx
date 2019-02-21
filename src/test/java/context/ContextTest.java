package context;

import com.wangbodang.employee.service.EmployeeService;
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
        EmployeeService employeeService = (EmployeeService) ctx.getBean("employeeService");
        employeeService.printAString();
    }

    @Test
    public void testDataSourceFromCtx(){
        EmployeeService employeeService = (EmployeeService) ctx.getBean("employeeService");
        employeeService.printListFromDataSource();
    }
    @Test
    public void testSqlSessionFromCtx(){
        EmployeeService employeeService = (EmployeeService) ctx.getBean("employeeService");
        employeeService.printListFromSqlSession();
    }
    @Test
    public void testEmpMapperFromCtx(){
        EmployeeService employeeService = (EmployeeService) ctx.getBean("employeeService");
        employeeService.printListFromEmployeeMapper();
    }
}
