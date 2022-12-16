package zw.co.tapiwajoel.zombies.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.tapiwajoel.zombies.models.RobotCpu;
import zw.co.tapiwajoel.zombies.service.RobotCpuService;
import zw.co.tapiwajoel.zombies.utils.dtos.ServiceResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/report-cpu")
@Slf4j
public class RobotCpuController {
    private final RobotCpuService robotCpuService;

    @GetMapping()
    public ResponseEntity<ServiceResponse<List<RobotCpu>>> getRobots() {
        log.info(":::::::: Get a list of robots :::::::");
        return ResponseEntity.ok(robotCpuService.getRobots());
    }
}
