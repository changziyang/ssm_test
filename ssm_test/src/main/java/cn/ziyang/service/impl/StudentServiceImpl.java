package cn.ziyang.service.impl;

import cn.ziyang.domain.Student;
import cn.ziyang.mapper.StudentMapper;
import cn.ziyang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findAll() {
        List<Student> studentList = studentMapper.findAll();
        return studentList;
    }

    public void add(Student student) {
        studentMapper.add(student);
    }

    public void update(Student student) {
        studentMapper.update(student);
    }

    public void del(Integer[] ids) {
        studentMapper.del(ids);
    }

    public Student findOne(int id) {
        Student student = studentMapper.findOne(id);
        return student;
    }
}
