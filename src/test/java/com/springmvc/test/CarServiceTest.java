package com.springmvc.test;

import com.springmvc.pojo.Car;
import com.springmvc.service.CarService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.io.File.pathSeparator;

public class CarServiceTest {
    private CarService carService;

    @Test
    public void pathSeparator(){
        System.out.println(pathSeparator);
    }

    @Test
    public void find(){
        for(Car car:carService.find("",null,null)){
            System.out.println(car.getName()+" "+car.getPrice()+" "+car.getCreateDate());
        }
    }

    @Before
    public void init(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        carService = (CarService)context.getBean("carService");
    }
}
