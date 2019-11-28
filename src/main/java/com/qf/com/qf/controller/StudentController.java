package com.qf.com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.entity.Student;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    public IStudentService studentService;

    @RequestMapping("/stu/listStudent")
    public String selectStudent(Model model,
                                @RequestParam(value = "start",defaultValue = "")int start,
                                @RequestParam(value = "size",defaultValue = "")int size){
        PageHelper.startPage(start,size);

        List<Student> stus = studentService.getStudent();
        PageInfo<Student> page = new PageInfo<>(stus);
        model.addAttribute("pages",page);
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
