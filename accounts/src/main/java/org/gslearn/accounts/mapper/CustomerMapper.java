package org.gslearn.accounts.mapper;

import org.gslearn.accounts.dto.CustomerDetailsDto;
import org.gslearn.accounts.dto.CustomerDto;
import org.gslearn.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setEmail(customer.getEmail());
        customerDto.setName(customer.getName());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setMobileNumber(customerDto.getMobileNumber());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }

    public static CustomerDetailsDto mapToCustomerDetailsDto(Customer customerDto, CustomerDetailsDto customerDetailsDto) {
        customerDetailsDto.setName(customerDto.getName());
        customerDetailsDto.setMobileNumber(customerDto.getMobileNumber());
        customerDetailsDto.setEmail(customerDto.getEmail());
        return customerDetailsDto;
    }
}
