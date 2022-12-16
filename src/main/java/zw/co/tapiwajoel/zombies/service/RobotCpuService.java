package zw.co.tapiwajoel.zombies.service;

import zw.co.tapiwajoel.zombies.models.RobotCpu;
import zw.co.tapiwajoel.zombies.utils.dtos.ServiceResponse;

import java.util.List;

public interface RobotCpuService {

    /**
     * Request to survivor.
     *
     * @return { @link List of Robots boolean}
     */
    ServiceResponse<List<RobotCpu>> getRobots();
}
