package com.example.firstspringbootproject.service;

import com.example.firstspringbootproject.exception.RecordNotFoundException;
import com.example.firstspringbootproject.model.Customer;
import com.example.firstspringbootproject.model.request.CreateCustomerRequest;
import com.example.firstspringbootproject.model.request.UpdateCustomerRequest;
import com.example.firstspringbootproject.model.response.DeleteCustomerResponse;
import com.example.firstspringbootproject.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
//        List<Customer> customers = new ArrayList<>();
//        Customer customer1 = new Customer();
//        customer1.setId(1L);
//        customer1.setName("ahmet");
//        customer1.setSurname("özcan");
//        customer1.setEmail("ozcanahmet94@gmail.com");
//        customer1.setPhoneNumber("+905419322436");
//        customers.add(customer1);
//
//        Customer customer2 = new Customer();
//        customer2.setId(2L);
//        customer2.setName("sevil");
//        customer2.setSurname("Toprak");
//        customer2.setEmail("sevilsevil@gmail.com");
//        customer2.setPhoneNumber("+905419322435");
//        customers.add(customer2);

        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public Customer getCustomerById(long id) throws RecordNotFoundException
    {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new  RecordNotFoundException("bu customer bulunamadı"));
        return customer;
    }

    public Customer createCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());
        customer.setEmail(request.getEmail());
        customer.setPhoneNumber(request.getPhoneNumber());
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(UpdateCustomerRequest request) throws RecordNotFoundException {
        Customer updatedCustomer = customerRepository.findById(request.getId()).orElseThrow(() -> new RecordNotFoundException("Bu İd ile customer bulunamadı"));
        if (Objects.nonNull(request.getName())){
            updatedCustomer.setName(request.getName());
        }
        if (Objects.nonNull(request.getSurname())){
            updatedCustomer.setSurname(request.getSurname());
        }
        if (Objects.nonNull(request.getEmail())){
            updatedCustomer.setEmail(request.getEmail());
        }
        if (Objects.nonNull(request.getPhoneNumber())){
            updatedCustomer.setPhoneNumber(request.getPhoneNumber());
        }
        return customerRepository.save(updatedCustomer);

    }

    public DeleteCustomerResponse deleteCustomerById(Long id) throws RecordNotFoundException {
        try {
            customerRepository.deleteById(id);
            DeleteCustomerResponse response = new DeleteCustomerResponse();
            response.setResponse(true);
            return response;
        } catch (Exception e){
            throw new RecordNotFoundException("Bu idli bir customer bulunmamaktadır");
        }
    }
}
