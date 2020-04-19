package com.jtoselli.flight

import com.jtoselli.flight.rest.TicketResource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    @Suppress("unused")
    fun api() = Docket(DocumentationType.SWAGGER_2)
            .select()
            //jtoselli: this is to exclude spring actuator if available, for example
            .apis(RequestHandlerSelectors.basePackage(TicketResource::class.java.getPackage().name))
            .paths(PathSelectors.any())
            .build()
            .useDefaultResponseMessages(false)!!
}