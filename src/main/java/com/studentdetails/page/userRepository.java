package com.studentdetails.page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user,Integer> {
    user findByMail(String mail);

    
}
