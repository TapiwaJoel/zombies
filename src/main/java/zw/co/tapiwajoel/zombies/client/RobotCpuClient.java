package zw.co.tapiwajoel.zombies.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import zw.co.tapiwajoel.zombies.models.RobotCpu;

import java.util.List;

@FeignClient(
        value = "robotCpu",
        url = "${zombies.robotCpu.url}"
)
public interface RobotCpuClient {
    @GetMapping(value = "/robotcpu", produces = "application/json")
    List<RobotCpu> getAccountDetails();
}
