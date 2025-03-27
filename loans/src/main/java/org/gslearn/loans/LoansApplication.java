package org.gslearn.loans;

import org.gslearn.loans.audit.AuditAwareImpl;
import org.gslearn.loans.dto.LoansApplicationDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(
        auditorAwareRef = "auditAwareImpl"
)
@EnableConfigurationProperties({LoansApplicationDto.class})
public class LoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }

}
