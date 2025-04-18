package org.gslearn.accounts.service.client;

import org.gslearn.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="loans",fallback = LoansFallback.class)
public interface LoansFeignClient {
    @GetMapping(value = "/api/fetch",consumes="application/json")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestHeader("eazybank-correlation-id")String correlationId,@RequestParam String mobileNumber);
}
