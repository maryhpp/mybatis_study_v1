package com.kuang.dao;

import com.kuang.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //查询所有的学生的信息，以及对应的老师的信息
    public List<Student> getStudent(int i);

    public List<Student> getStudent2(int i);
}
