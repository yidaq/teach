package com.teach;

import com.teach.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeachApplicationTests {

    @Test
    public void contextLoads() {
        String a = "123";
        System.out.println(MD5Util.MD5EncodeUtf8(a));
    }

}
