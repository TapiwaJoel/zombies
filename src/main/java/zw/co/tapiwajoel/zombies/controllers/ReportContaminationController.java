package zw.co.tapiwajoel.zombies.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.tapiwajoel.zombies.models.ReportContamination;
import zw.co.tapiwajoel.zombies.service.ReportContaminationService;
import zw.co.tapiwajoel.zombies.utils.dtos.ServiceResponse;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/report-contamination")
@Slf4j
public class ReportContaminationController {

    private final ReportContaminationService reportContaminationService;

    @PostMapping("/{survivorId}")
    @Operation(summary = "Report Contamination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Report Contamination added successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class))
                    })
    })
    public ResponseEntity<ServiceResponse<ReportContamination>> save(@PathVariable long survivorId) {
        log.info(":::::::: Report Contamination :::::::");
        return ResponseEntity.ok(reportContaminationService.reportContamination(survivorId));
    }
}
