package cn.ziyang.service;

import cn.ziyang.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public void add(Student student);
    public void update(Student student);
    public void del(Integer[] ids);
    public Student findOne(int id);
}
