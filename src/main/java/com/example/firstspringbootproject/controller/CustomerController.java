package com.example.firstspringbootproject.controller;

import com.example.firstspringbootproject.exception.RecordNotFoundException;
import com.example.firstspringbootproject.model.Customer;
import com.example.firstspringbootproject.model.request.CreateCustomerRequest;
import com.example.firstspringbootproject.model.request.UpdateCustomerRequest;
import com.example.firstspringbootproject.model.response.DeleteCustomerResponse;
import com.example.firstspringbootproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/customer")
@RequiredArgsConstructor
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/")
    ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = customerService.getAllCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Customer> getCustomerById(@PathVariable String id) throws RecordNotFoundException {
        Customer customer = customerService.getCustomerById(Long.valueOf(id));
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/")
    ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomerRequest request) {
        Customer customer = customerService.createCustomer(request);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/")
    ResponseEntity<Customer> updateCustomer(@RequestBody UpdateCustomerRequest request) throws RecordNotFoundException {
        Customer customer = customerService.updateCustomer(request);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<DeleteCustomerResponse> deleteCustomerById(@PathVariable String id) throws RecordNotFoundException {
        DeleteCustomerResponse response = customerService.deleteCustomerById(Long.valueOf(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

