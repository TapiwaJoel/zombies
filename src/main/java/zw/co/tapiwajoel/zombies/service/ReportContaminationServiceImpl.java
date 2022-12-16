package zw.co.tapiwajoel.zombies.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zw.co.tapiwajoel.zombies.exceptions.BadRequestException;
import zw.co.tapiwajoel.zombies.models.ReportContamination;
import zw.co.tapiwajoel.zombies.models.Survivor;
import zw.co.tapiwajoel.zombies.repository.ReportContaminationRepository;
import zw.co.tapiwajoel.zombies.repository.SurvivorRepository;
import zw.co.tapiwajoel.zombies.utils.dtos.ServiceResponse;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReportContaminationServiceImpl implements ReportContaminationService {
    private final SurvivorRepository survivorRepository;
    private final ReportContaminationRepository reportContaminationRepository;

    @Override
    public ServiceResponse<ReportContamination> reportContamination(long survivorId) {
        try {

            log.info("Search for survivor with id ::: {} ", survivorId);

            Optional<ReportContamination> contaminationReports = reportContaminationRepository
                    .findBySurvivorId(survivorId);

            if (!contaminationReports.isPresent()) {

                Survivor survivor = survivorRepository.findById(survivorId).orElseThrow(null);

                ReportContamination reportContamination = ReportContamination.builder()
                        .numberOfReports(1)
                        .survivor(survivor)
                        .build();

                ReportContamination reportContamination1 = reportContaminationRepository.save(reportContamination);

                return ServiceResponse.<ReportContamination>builder()
                        .data(reportContamination1)
                        .message("A contamination report created successfully")
                        .build();

            }

            ReportContamination reportContamination = contaminationReports.get();

            log.info("contaminationReports ::: {}", contaminationReports);

                if (reportContamination.getNumberOfReports() < 3) {

                    int numberOfContaminationReports = reportContamination.getNumberOfReports();
                    reportContamination.setNumberOfReports(numberOfContaminationReports + 1);

                    ReportContamination updatedReportContamination =
                            reportContaminationRepository.save(reportContamination);

                    if (updatedReportContamination.getNumberOfReports() == 3) {
                        Survivor survivor = survivorRepository.findById(survivorId).orElseThrow(null);
                        survivor.setInfected(true);
                        survivorRepository.save(survivor);
                    }

                    return ServiceResponse.<ReportContamination>builder()
                            .data(updatedReportContamination)
                            .message("A contamination report created successfully")
                            .build();
                }

                return ServiceResponse.<ReportContamination>builder()
                        .data(null)
                        .message("A contamination report created successfully")
                        .build();
        } catch (Exception exception) {
            throw new BadRequestException(exception.getMessage());
        }
    }
}
