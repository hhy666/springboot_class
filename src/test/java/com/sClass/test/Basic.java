package com.sClass.test;

import com.sClass.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)//启动springboot应用
@SpringBootTest(classes = Application.class)//指定springboot入口类
public class Basic {
}
