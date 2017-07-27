package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTest {

    @BeforeClass
    public static void classBefore() {
        // ִֻ�� һ��
        System.out.println("classBefore();");
    }
    
    @Before
    public void methodBefore() {
        // ÿ������ִ��ǰִ��һ��
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
        // ÿ������ִ�к�ִ��һ��
        System.out.println("methodAfter();");
    }

    @AfterClass
    public static void classAfter() {
        // ִֻ��һ��
        System.out.println("classAfter();");
    }
}
