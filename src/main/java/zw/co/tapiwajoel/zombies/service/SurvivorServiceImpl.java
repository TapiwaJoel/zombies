package zw.co.tapiwajoel.zombies.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zw.co.tapiwajoel.zombies.exceptions.BadRequestException;
import zw.co.tapiwajoel.zombies.models.Location;
import zw.co.tapiwajoel.zombies.models.Survivor;
import zw.co.tapiwajoel.zombies.repository.SurvivorRepository;
import zw.co.tapiwajoel.zombies.utils.dtos.ServiceResponse;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class SurvivorServiceImpl implements SurvivorService {

    private final SurvivorRepository survivorRepository;

    @Override
    public ServiceResponse<Survivor> save(Survivor survivor) {
        return ServiceResponse.<Survivor>builder()
                .data(survivorRepository.save(survivor))
                .message("Survivor created successfully")
                .build();
    }

    @Override
    public ServiceResponse<Survivor> updateLastLocation(long survivorId, Location location) {
        try {
            Survivor survivor = survivorRepository.findById(survivorId).orElseThrow(null);
            survivor.setLastLocation(location);
            Survivor survivorUpdated = survivorRepository.save(survivor);

            return ServiceResponse.<Survivor>builder()
                    .data(survivorUpdated)
                    .message("Survivor last location updated successfully")
                    .build();
        } catch (Exception exception) {
            throw new BadRequestException(exception.getMessage());
        }
    }

    @Override
    public ServiceResponse<List<Survivor>> getInfected() {


        Optional<List<Survivor>> byInfected = survivorRepository.findByInfected(true);

        if (!byInfected.isPresent()) {
            throw new BadRequestException("There are no infected survivors");
        }

        return ServiceResponse.<List<Survivor>>builder()
                .data(byInfected.get())
                .message("A list of infected survivors")
                .build();
    }

    @Override
    public ServiceResponse<Double> getInfectedPercentage() {
        long allSurvivors = survivorRepository.count();
        long allInfectedSurvivors = survivorRepository.countByInfected(true);

        if (allSurvivors == 0 || allInfectedSurvivors == 0) {
            throw new BadRequestException("There are no infected survivors");
        }

        Double percentage = (double) ((allInfectedSurvivors / allSurvivors) * 100);

        return ServiceResponse.<Double>builder()
                .message("Percentage of infected survivors")
                .data(percentage)
                .build();
    }

    @Override
    public ServiceResponse<List<Survivor>> getNonInfected() {
        Optional<List<Survivor>> byInfected = survivorRepository.findByInfected(false);

        if (!byInfected.isPresent()) {
            throw new BadRequestException("There are no non-infected survivors");
        }

        return ServiceResponse.<List<Survivor>>builder()
                .data(byInfected.get())
                .message("A list of non-infected survivors")
                .build();
    }

    @Override
    public ServiceResponse<Double> getNonInfectedPercentage() {
        long allSurvivors = survivorRepository.count();
        long allInfectedSurvivors = survivorRepository.countByInfected(false);

        if (allSurvivors == 0 || allInfectedSurvivors == 0) {
            throw new BadRequestException("There are no non-infected survivors");
        }

        Double percentage = (double) ((allInfectedSurvivors / allSurvivors) * 100);

        return ServiceResponse.<Double>builder()
                .message("Percentage of non-infected survivors")
                .data(percentage)
                .build();
    }
}
