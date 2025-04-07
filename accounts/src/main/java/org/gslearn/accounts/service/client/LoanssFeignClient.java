package org.gslearn.accounts.service.client;

import org.gslearn.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("loans")
public class LoanssFeignClient {
    @GetMapping("/api/fetch",consumes="application/json")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam String mobileNumber);
}
