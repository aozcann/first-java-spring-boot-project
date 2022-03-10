package com.example.firstspringbootproject.repository;

import com.example.firstspringbootproject.model.Customer;
import com.example.firstspringbootproject.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}


//@Repository
//public interface CustomerRepository extends JpaRepository<Customer, Long> {
//}
