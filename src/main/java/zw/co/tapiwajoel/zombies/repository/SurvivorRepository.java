package zw.co.tapiwajoel.zombies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.tapiwajoel.zombies.models.Survivor;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long> {

    Optional<List<Survivor>> findByInfected(boolean infected);
    int countByInfected(boolean infected);
}
