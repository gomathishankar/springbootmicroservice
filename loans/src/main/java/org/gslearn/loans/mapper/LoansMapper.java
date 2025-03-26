package org.gslearn.loans.mapper;

import org.gslearn.loans.dto.LoansDto;
import org.gslearn.loans.entity.Loans;


public class LoansMapper {

    public static Loans mapToLoans(LoansDto loansDto, Loans loans){
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setLoanType(loansDto.getLoanType());
        loans.setMobileNumber(loansDto.getMobileNumber());
        return loans;
    }

    public static LoansDto mapToLoansDto(Loans loans, LoansDto loansDto){
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setMobileNumber(loans.getMobileNumber());
        return loansDto;
    }
}
