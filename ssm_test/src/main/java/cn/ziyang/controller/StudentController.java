package cn.ziyang.controller;

import cn.ziyang.domain.Student;
import cn.ziyang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    //查询全部
@RequestMapping("/findAll")
    public ModelAndView findAll(){
    List<Student> studentList = studentService.findAll();
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("studentList",studentList);
    modelAndView.setViewName("list");
    return modelAndView;
}
//添加
    @RequestMapping("/add")
    public String add(Student student){
        studentService.add(student);
        return "redirect:/student/findAll";
    }
    @RequestMapping("/findOne")
    public ModelAndView findOne(int id){
        Student student = studentService.findOne(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student",student);
        modelAndView.setViewName("update");
        return modelAndView;
    }
    //修改
    @RequestMapping("update")
    public String update(Student student){
    studentService.update(student);
    return "redirect:/student/findAll";
    }
    //删除
    @RequestMapping("del")
    public String del(Integer[] ids){
    studentService.del(ids);
    return "redirect:/student/findAll";
    }
}
