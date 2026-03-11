package org.example.IOC_WITH_XML;

import org.example.IOC_WITH_XML.Laptop;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        //BeansFactory
        BeanFactory beanFactory1=new ClassPathXmlApplicationContext("beans.xml");
        Laptop l1=(Laptop)beanFactory1.getBean("laptop");
        System.out.println(l1);
        System.out.println();


        //Application Context
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
//
//        Laptop laptop = context.getBean("laptop2", Laptop.class);
//
//        System.out.println(laptop);


        //object to object injection
//        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");//
        Developer dev=context.getBean("dev",Developer.class);
        dev.buildDev();
    }
}