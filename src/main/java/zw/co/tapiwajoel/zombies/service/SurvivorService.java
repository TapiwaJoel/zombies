package zw.co.tapiwajoel.zombies.service;

import zw.co.tapiwajoel.zombies.models.Location;
import zw.co.tapiwajoel.zombies.models.Survivor;
import zw.co.tapiwajoel.zombies.utils.dtos.ServiceResponse;

import java.util.List;

public interface SurvivorService {

    /**
     * Request to survivor.
     *
     * @param survivor survivor request object
     * @return {@link ServiceResponse<Survivor>}
     */
    ServiceResponse<Survivor> save(Survivor survivor);
    ServiceResponse<Survivor> updateLastLocation(long survivorId, Location location);
    ServiceResponse<List<Survivor>> getInfected();
    ServiceResponse<Double> getInfectedPercentage();
    ServiceResponse<List<Survivor>> getNonInfected();
    ServiceResponse<Double> getNonInfectedPercentage();
}
