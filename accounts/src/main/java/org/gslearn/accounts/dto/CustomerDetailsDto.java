package org.gslearn.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name="Customer",
    description = "Schema to hold Customer account, cards and loans")
public class CustomerDetailsDto {
  @Schema(
      description = "Name of the customer",
      example = "Eazy Bytes"
  )
  @NotEmpty(message = "Name cannot be null or empty")
  @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 to 30")
  private String name;
  @NotEmpty(message = "Email Id is not null or empty")
  @Email(message = "Email address should be valid")
  @Schema(
      description = "Email address of the customer", example = "tutor@eazybytes.com"
  )
  private String email;
  @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
  @Schema(
      description = "Mobile Number of the customer", example = "9345432123"
  )
  private String mobileNumber;
  @Schema(
      description = "Account details of the Customer"
  )
  private AccountsDto accountsDto;

  @Schema(
      description = "Cards details of the Customer"
  )
  private CardsDto cardsDto;

  @Schema(
      description = "Loans details of the Customer"
  )
  private LoansDto loansDto;
}
