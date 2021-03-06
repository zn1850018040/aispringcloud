package com.zn.controller;

import com.zn.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * @ClassName StudentController
 * @Description TODO
 * @Author 张能
 * @Date 2020/8/24 23:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/rest")
public class RestTemplateController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class).getBody();
    }

    @GetMapping("findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://localhost:8010/student/findById/{id}",Student.class,id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") Long id){
        restTemplate.delete("http://localhost:8010/student/delete/{id}",id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8010/student/save",student,null);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") Long id){
        restTemplate.put("http://localhost:8010/student/update/{id}",id);
    }
}
