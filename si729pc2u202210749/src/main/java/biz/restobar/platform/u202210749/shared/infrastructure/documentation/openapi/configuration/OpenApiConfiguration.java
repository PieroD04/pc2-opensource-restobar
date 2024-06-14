package biz.restobar.platform.u202210749.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI restobarPlatformOpenApi() {
        var openApi = new OpenAPI();
        openApi
                .info(new Info()
                        .title("Restobar Biz API")
                        .description("Restobar Biz API for managing the reservations.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Restobar Biz Platform Wiki Documentation")
                        .url("https://restobar-biz-platform.wiki.github.io/docs"));
        return openApi;
    }
}


