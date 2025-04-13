package org.gslearn.accounts.service;

import org.gslearn.accounts.dto.CustomerDetailsDto;

public interface ICustomersService {
  CustomerDetailsDto fetchCustomerDetails(String mobileNumber,String correlationId);
}
