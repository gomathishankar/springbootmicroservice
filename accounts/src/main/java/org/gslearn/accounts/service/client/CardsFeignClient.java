package org.gslearn.accounts.service.client;

import org.gslearn.accounts.dto.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("cards")
public interface CardsFeignClient {
    @GetMapping(value = "/api/fetch",consumes="application/json")
    public ResponseEntity<CardsDto> fetchCardDetails(@RequestParam String mobileNumber);
}
