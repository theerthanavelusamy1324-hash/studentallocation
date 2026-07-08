package com.studentdetails.page;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;








@RestController
@CrossOrigin("*")

public class maincontroller {
    @Autowired
    userRepository repo;
    @PostMapping("/signup")
    public String signup(@RequestParam String name, @RequestParam String mail, @RequestParam String password) {
        user existing = repo.findByMail(mail);
        if(existing != null){
            return "Already mail exist";
        }
        user u = new user();
        u.setName(name);
        u.setMail(mail);
        u.setPassword(password);
        repo.save(u);
        return "Signup success";
    }
    @PostMapping("/login")
    public String login(@RequestParam String mail, @RequestParam String password) {
        user user = repo.findByMail(mail);
        if(user == null){
            return "User not found";
        }
        if(user.getPassword().equals(password)){
            return "success";
        }
        return "Invalid password";
    }
    @Autowired
    studentRepository studentrepo;
    @GetMapping("/register")
    public student register(@RequestParam int studentid,@RequestParam String studentname, @RequestParam int marks, @RequestParam String category, @RequestParam String type, @RequestParam String status) {
        student s = new student();
        s.setStudentid(studentid);
        s.setStudentname(studentname);
        s.setMarks(marks);
        s.setCategory(category);
        s.setType(type);
        if(s.getMarks() >= 65){
            s.setStatus("Allocated");
        }
        else{
            s.setStatus("Not Allocated");
        }
        return studentrepo.save(s);
    }
    @GetMapping("/studentdetails")
    public List<student> getDetails() {
        return studentrepo.findAll();
    }
    @GetMapping("/studentcount")
    public long studentcount() {
        return studentrepo.count();
    }
   
    @GetMapping("/allocated")
    public List<student> getallocated() {
        return  studentrepo.findByStatus("Allocated");
    }
    @GetMapping("/allocatecount")
    public long getallocatecount() {
        return studentrepo.countByStatus("Allocated");
    }
     @GetMapping("/notallocatecount")
    public long getnotallocatecount() {
        return studentrepo.countByStatus("Not Allocated");
    }
    @GetMapping("/send")
    public String send(@RequestParam String text) {
       switch (text) {
        case "hi":
            return "Hello how are you?";
             case "total students":
            return "Total Students are " + studentcount();
             case "allocated students":
            return "Total allocated students are " + getallocatecount();
              case "not allocated students":
            return "Not allocated students are " + getnotallocatecount();
               case "available seats":
            return "Available seats are 365";
              case "total course":
            return "Total courses are 10";
        default:
            return "Invalid choice";
           
       }
    }
    
    
    
    
  
   
   
    
    
    
    
    
    
    
    
}
