package com.springmvc.service;

import com.springmvc.mapper.CarMapper;
import com.springmvc.pojo.Car;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CarService {
    @Resource(name = "carMapper")
    private CarMapper carMapper;

    public List<Car> find(String name, Date beginDate, Date endDate) {
        return carMapper.find(name, beginDate, endDate);
    }

    public Car find(Integer id) {
        return carMapper.findById(id);
    }

    public int add(Car car) {
        return carMapper.add(car);
    }

    public int modify(Car car) {
        return carMapper.modify(car);
    }

    public int remove(Integer id) {
        return carMapper.remove(id);
    }
}
