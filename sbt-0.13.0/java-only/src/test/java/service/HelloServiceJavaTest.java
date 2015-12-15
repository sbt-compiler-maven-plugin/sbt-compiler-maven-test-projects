package service;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloServiceJavaTest
{
    @Test
    public void test1()
    {
        assertEquals("Hello", HelloServiceJava.instance.hello());
    }

}
