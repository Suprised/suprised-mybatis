package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTest {

    @BeforeClass
    public static void classBefore() {
        // 只执行 一次
        System.out.println("classBefore();");
    }
    
    @Before
    public void methodBefore() {
        // 每个方法执行前执行一次
        System.out.println("methodBefore();");
    }
    
    @Test
    public void method1() {
        System.out.println("method1();");
    }
    
    @Test 
    public void method2() {
        System.out.println("method2();");
    }
    
    @After
    public void methodAfter() {
        // 每个方法执行后执行一次
        System.out.println("methodAfter();");
    }

    @AfterClass
    public static void classAfter() {
        // 只执行一次
        System.out.println("classAfter();");
    }
}
