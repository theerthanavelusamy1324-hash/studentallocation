package com.studentdetails.page;
import jakarta.persistence.*;
@Entity
@Table(name="student")

public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int studentid;
    private String studentname;
    private int marks;
    private String category;
    private String type;
    private String status;
    public student(){}
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getStudentid(){
        return studentid;
    }
    public void setStudentid(int studentid){
        this.studentid = studentid;
    }
    public String getStudentname(){
        return studentname;
    }
    public void setStudentname(String studentname){
        this.studentname = studentname;
    }
     public int getMarks(){
        return marks;
    }
    public void setMarks(int marks){
        this.marks = marks;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
     public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    
}
