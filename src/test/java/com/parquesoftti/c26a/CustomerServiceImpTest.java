package com.parquesoftti.c26a;

import com.parquesoftti.c26a.model.Customer;
import com.parquesoftti.c26a.repository.CustomerRepository;
import com.parquesoftti.c26a.service.CustomerServicesImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceImpTest {

    private Customer customer;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServicesImp customerService;


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        customer= new Customer();
        customer.setCustomerId(1L);
        customer.setEmail("MMM@GMAIL.COM");
        customer.setCustomerName("Juan");
        customer.setPhoneNumber("123456789");
    }



@Test
void findAll(){
        List<Customer> lst = new ArrayList<>();
        lst.add(customer);
        when(customerRepository.findAll()).thenReturn(lst);
        List<Customer> tmpList= customerService.findAll();
        assertEquals(1,tmpList.size());
}

    @Test
    void findById() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        Customer result = customerService.findById(1L);

        assertNotNull(result);
        assertEquals("Juan", result.getCustomerName());
        verify(customerRepository, times(1)).findById(1L);
    }

}

