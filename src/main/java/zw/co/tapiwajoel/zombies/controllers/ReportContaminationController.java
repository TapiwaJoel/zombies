package zw.co.tapiwajoel.zombies.controllers;

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
    public ResponseEntity<ServiceResponse<ReportContamination>> save(@PathVariable long survivorId) {
        log.info(":::::::: Report Contamination :::::::");
        return ResponseEntity.ok(reportContaminationService.reportContamination(survivorId));
    }
}
