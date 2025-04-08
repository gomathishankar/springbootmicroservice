package org.gslearn.accounts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.gslearn.accounts.dto.CustomerDetailsDto;
import org.gslearn.accounts.dto.ErrorResponseDto;
import org.gslearn.accounts.service.ICustomersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Tag(name = "Rest APIs for Customer details in Eazybank",
    description = "Rest APIS to provide Eazy bank customer details")
public class CustomerController {

  private final ICustomersService icustomersService;

  public CustomerController(ICustomersService icustomersService) {
    this.icustomersService = icustomersService;
  }

  @Operation(
      summary = "Fetch Customer Details REST API",
      description = "REST API to fetch Customer details based on a mobile number"
  )
  @ApiResponses({
      @ApiResponse(
          responseCode = "200",
          description = "HTTP Status OK"
      ),
      @ApiResponse(
          responseCode = "500",
          description = "HTTP Status Internal Server Error",
          content = @Content(
              schema = @Schema(implementation = ErrorResponseDto.class)
          )
      )
  })
  @GetMapping("/fetchCustomerDetails")
  public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestParam("mobileNumber")
                                                                   @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
                                                                   String mobileNumber){
    CustomerDetailsDto customerDetailsDto = icustomersService.fetchCustomerDetails(mobileNumber);
    return ResponseEntity.status(HttpStatus.OK).body(customerDetailsDto);

  }
}
