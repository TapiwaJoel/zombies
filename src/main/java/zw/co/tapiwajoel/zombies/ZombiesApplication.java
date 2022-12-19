package zw.co.tapiwajoel.zombies;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
@OpenAPIDefinition(
        info = @Info(
                title = "Zombies Service API",
                version = "1.0",
                description = "RESTful Zombies Service "
        )
)
@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class ZombiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZombiesApplication.class, args);
    }
}
