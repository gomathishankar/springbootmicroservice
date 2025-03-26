package org.gslearn.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(title = " Accounts microservice Rest Api Documentations",
        description = "Eazybank Application",
        version = "v1",
        contact = @Contact(
                name = "GS",
                email = "Gs@test.com",
                url = "http://localhost:8080"
        ),
        license = @License(name = "Apache 2.0",
                url = "http://localhost:8080"
        )),
        externalDocs = @ExternalDocumentation
                (description = "Eazy bank Account MS",
                        url = "http://localhost:8080"))
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
