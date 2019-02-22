package hibernate;

import com.wangbodang.book.entity.Book;
import com.wangbodang.book.service.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class ContextTest {

    private ApplicationContext context;
    private BookService bookService=null;

    /**
     * load and close spring context
     */
    @Before
    public void init(){
        String contextConfig = "conf/contextHibernate.xml";
        context = new ClassPathXmlApplicationContext(contextConfig);
        bookService=context.getBean(BookService.class);
    }
    @After
    public void destory(){
        ((AbstractApplicationContext)context).close();
    }


    @Test
    public void testSprintContext(){
        DataSource dataSource=(DataSource) context.getBean(DataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void test2()
    {
        String bookName=bookService.findBookById(1);
        System.out.println(bookName);
    }

    @Test
    public void test3()
    {
        bookService.saveBook(new Book(2, "android源码分析", "1002", 45, 10));
    }


}
