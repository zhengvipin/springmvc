package com.springmvc.mapper;

import com.springmvc.pojo.Car;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 映射器类
 *
 * @author Zheng
 */
@Repository
public interface CarMapper {
    /**
     * 模糊查询 | 查询全部
     *
     * @param name      车名
     * @param beginDate 起始时间
     * @param endDate   截止时间
     * @return
     */
    List<Car> find(@Param("name") String name,
                   @Param("beginDate") Date beginDate,
                   @Param("endDate") Date endDate);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Select("select * from car where id=#{id}")
    Car findById(Integer id);

    /**
     * 增加
     *
     * @param car
     * @return
     */
    @Insert("insert into car(name,price,createDate,img) values(#{name},#{price},#{createDate},#{img})")
    int add(Car car);

    /**
     * 修改
     *
     * @param car
     * @return
     */
    @Update("update car set name=#{name},price=#{price},createDate=#{createDate},img=#{img} where id=#{id}")
    int modify(Car car);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Delete("delete from car where id=#{id}")
    int remove(Integer id);
}
