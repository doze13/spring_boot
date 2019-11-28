package com.qf.com.qf.controller;

import com.qf.entity.Student;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *学生管理系统
 */
@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    public IStudentService studentService;

    @RequestMapping("/selectStudent")
    public String selectStudent(Model model,@RequestParam(value="pageNum") String pageNum){

        List<Student> stus = studentService.list();
        model.addAttribute("stus",stus);
        return "stulist";
    }

    @RequestMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable ("id") Integer id){

        studentService.removeById(id);
        return "redirect:/stu/selectStudent";
    }

    @RequestMapping("/addStu")
    public String addStu(){

        return "add";
    }

    @RequestMapping("/addStudent")
    public String addStudent(Student student){
        System.out.println("添加！！");
        System.out.println(student);
        studentService.save(student);
        return "redirect:/stu/selectStudent";
    }
}
