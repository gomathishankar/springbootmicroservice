package org.gslearn.accounts.service.impl;

import lombok.AllArgsConstructor;
import org.gslearn.accounts.dto.AccountsDto;
import org.gslearn.accounts.dto.CardsDto;
import org.gslearn.accounts.dto.CustomerDetailsDto;
import org.gslearn.accounts.dto.CustomerDto;
import org.gslearn.accounts.dto.LoansDto;
import org.gslearn.accounts.entity.Accounts;
import org.gslearn.accounts.entity.Customer;
import org.gslearn.accounts.exception.ResourceNotFoundException;
import org.gslearn.accounts.mapper.AccountsMapper;
import org.gslearn.accounts.mapper.CustomerMapper;
import org.gslearn.accounts.repository.AccountsRepository;
import org.gslearn.accounts.repository.CustomerRepository;
import org.gslearn.accounts.service.ICustomersService;
import org.gslearn.accounts.service.client.CardsFeignClient;
import org.gslearn.accounts.service.client.LoansFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomersService {

  private AccountsRepository accountsRepository;
  private CustomerRepository customerRepository;
  private CardsFeignClient cardsFeignClient;
  private LoansFeignClient loansFeignClient;

  @Override
  public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
    Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer does not exist", "mobileNumber", mobileNumber));
    Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));
    CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
    customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));
    ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
    customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
    ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
    customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
    return customerDetailsDto;
  }
}
