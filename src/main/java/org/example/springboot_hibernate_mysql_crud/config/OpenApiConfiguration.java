package org.example.springboot_hibernate_mysql_crud.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info= @Info(
                contact = @Contact(
                        name = "Verygood Muhirwa",
                        email = "verygoodmuhirwa2@gmail.com",
                        url = "http://localhost:3500/api"
                ),
                title = "Open api specification -Verygood ",
                description = "Documentation for springboot student crud with hibernate",
                version = "1.0",

                license = @License(
                        name = "License name",
                        url = "http://some-url.com"
                ),

                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local environment server",
                        url = "http://localhost:3500"
                ),

                @Server(
                        description = "Production envr",
                        url = "http://localhost:3500"
                ),


        }
)
public class OpenApiConfiguration {
}
