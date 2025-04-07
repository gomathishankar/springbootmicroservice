package org.gslearn.accounts.service.client;

import org.gslearn.accounts.dto.CardsDto;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cards")
public class CardsFeignClient {
    @GetMapping("/api/fetch",consumes="application/json")
    public ResponseEntity<CardsDto> fetchCardDetails(@RequestParam String mobileNumber);
}
