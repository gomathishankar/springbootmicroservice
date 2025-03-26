package org.gslearn.loans.service;

import org.gslearn.loans.dto.LoansDto;
import org.springframework.stereotype.Service;

@Service
public interface ILoansService {
    void createLoan(String mobileNumber);
    LoansDto fetchLoan(String mobileNumber);
    boolean updateLoan(LoansDto loansDto);
    boolean deleteLoan(String mobileNumber);
}
