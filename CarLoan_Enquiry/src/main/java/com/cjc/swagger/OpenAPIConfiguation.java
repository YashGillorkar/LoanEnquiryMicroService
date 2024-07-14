package com.cjc.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;

@Configuration
public class OpenAPIConfiguation {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:1111");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Yash Gillorkar");
        myContact.setEmail("yashgillorkar04@gmail.com");

        Info information = new Info().title("Car Loan Enquiry API's").version("1.0")
                .description("This API exposes endpoints regarding loan enquiry.").contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
