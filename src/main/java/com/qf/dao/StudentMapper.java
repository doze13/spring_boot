package com.qf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    @Select("select * from student where CONCAT(id,name,age,birthday)")
    List<Student> getStudent();
    /*  void addStudent(Student student);*/
}
