package com.studentdetails.page;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface studentRepository extends JpaRepository<student,Integer> {
  List<student> findByStatus(String status);
  long countByStatus(String status);
    
}
