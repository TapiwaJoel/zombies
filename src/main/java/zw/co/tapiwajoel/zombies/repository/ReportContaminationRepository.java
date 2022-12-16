package zw.co.tapiwajoel.zombies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.tapiwajoel.zombies.models.ReportContamination;

import java.util.Optional;

@Repository
public interface ReportContaminationRepository extends JpaRepository<ReportContamination, Long> {
    Optional<ReportContamination> findBySurvivorId(long survivorId);
}
