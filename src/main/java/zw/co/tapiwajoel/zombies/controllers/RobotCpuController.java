package zw.co.tapiwajoel.zombies.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Get a list of robots")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "A list of robots successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class))
                    })
    })
    public ResponseEntity<ServiceResponse<List<RobotCpu>>> getRobots() {
        log.info(":::::::: Get a list of robots :::::::");
        return ResponseEntity.ok(robotCpuService.getRobots());
    }
}
