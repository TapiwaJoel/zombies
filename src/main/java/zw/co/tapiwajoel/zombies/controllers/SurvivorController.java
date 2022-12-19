package zw.co.tapiwajoel.zombies.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Add survivor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Survivor added successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class))
                    })
    })
    public ResponseEntity<ServiceResponse<Survivor>> save(@Valid @RequestBody Survivor survivor) {
        log.info(":::::::: Adding Survivors :::::::");
        return ResponseEntity.ok(survivorService.save(survivor));
    }


    @Operation(summary = "Update survivor last location")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Location updated successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class))
                    })
    })
    @PutMapping("/last-location/{survivorId}")
    public ResponseEntity<ServiceResponse<Survivor>> updateLastLocation(@PathVariable long survivorId,
                                                                        @Valid @RequestBody Location location) {
        log.info(":::::::: Adding Survivors :::::::");
        return ResponseEntity.ok(survivorService.updateLastLocation(survivorId, location));
    }


    @Operation(summary = "Get a list of infected survivors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Infected survivors retrieved successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class))
                    })
    })
    @GetMapping("/infected")
    public ResponseEntity<ServiceResponse<List<Survivor>>> getInfected() {
        log.info(":::::::: Get Infected Survivors :::::::");
        return ResponseEntity.ok(survivorService.getInfected());
    }


    @Operation(summary = "Get of infected survivors as a percentage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Infected survivors retrieved successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class))
                    })
    })
    @GetMapping("/infected/percentage")
    public ResponseEntity<ServiceResponse<Double>> getInfectedAsAPercentage() {
        log.info(":::::::: Get Infected Survivors As Percentage :::::::");
        return ResponseEntity.ok(survivorService.getInfectedPercentage());
    }


    @Operation(summary = "Get a list of non-infected survivors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Non-Infected survivors retrieved successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class))
                    })
    })
    @GetMapping("/non-infected")
    public ResponseEntity<ServiceResponse<List<Survivor>>> getNonInfected() {
        log.info(":::::::: Get Non-Infected Survivors :::::::");
        return ResponseEntity.ok(survivorService.getNonInfected());
    }


    @GetMapping("/non-infected/percentage")
    @Operation(summary = "Get non-infected survivors as a percentage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Non-Infected survivors retrieved successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class))
                    })
    })
    public ResponseEntity<ServiceResponse<Double>> getNonInfectedPercentage() {
        log.info(":::::::: Get Non-Infected Survivors As A Percentage :::::::");
        return ResponseEntity.ok(survivorService.getNonInfectedPercentage());
    }
}
