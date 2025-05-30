package com.gslearn.message.functions;

import com.gslearn.message.dto.AccountsMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {
    private static final Logger LOG = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<AccountsMessageDto,AccountsMessageDto> email(){
        return accountsMessageDto -> {
            LOG.info("Sending email with the details: {}",accountsMessageDto.toString());
            return accountsMessageDto;
        };
    }

    @Bean
    public Function<AccountsMessageDto,Long> sms(){
        return accountsMessageDto -> {
            LOG.info("Sending sms with the details: {}",accountsMessageDto.toString());
            return accountsMessageDto.accountNumber();
        };
    }

}
