package zw.co.tapiwajoel.zombies.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.tapiwajoel.zombies.models.Location;
import zw.co.tapiwajoel.zombies.models.Survivor;
import zw.co.tapiwajoel.zombies.service.SurvivorService;
import zw.co.tapiwajoel.zombies.utils.dtos.ServiceResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/survivors")
@Slf4j
public class SurvivorController {

    private final SurvivorService survivorService;

    @PostMapping
    public ResponseEntity<ServiceResponse<Survivor>> save(@Valid @RequestBody Survivor survivor) {
        log.info(":::::::: Adding Survivors :::::::");
        return ResponseEntity.ok(survivorService.save(survivor));
    }

    @PutMapping("/last-location/{survivorId}")
    public ResponseEntity<ServiceResponse<Survivor>> updateLastLocation(@PathVariable long survivorId,
                                                                        @Valid @RequestBody Location location) {
        log.info(":::::::: Adding Survivors :::::::");
        return ResponseEntity.ok(survivorService.updateLastLocation(survivorId, location));
    }

    @GetMapping("/infected")
    public ResponseEntity<ServiceResponse<List<Survivor>>> getInfected() {
        log.info(":::::::: Get Infected Survivors :::::::");
        return ResponseEntity.ok(survivorService.getInfected());
    }

    @GetMapping("/infected/percentage")
    public ResponseEntity<ServiceResponse<Double>> getInfectedAsAPercentage() {
        log.info(":::::::: Get Infected Survivors As Percentage :::::::");
        return ResponseEntity.ok(survivorService.getInfectedPercentage());
    }

    @GetMapping("/non-infected")
    public ResponseEntity<ServiceResponse<List<Survivor>>> getNonInfected() {
        log.info(":::::::: Get Non-Infected Survivors :::::::");
        return ResponseEntity.ok(survivorService.getNonInfected());
    }

    @GetMapping("/non-infected/percentage")
    public ResponseEntity<ServiceResponse<Double>> getNonInfectedPercentage() {
        log.info(":::::::: Get Non-Infected Survivors As A Percentage :::::::");
        return ResponseEntity.ok(survivorService.getNonInfectedPercentage());
    }
}
