package zw.co.tapiwajoel.zombies.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zw.co.tapiwajoel.zombies.client.RobotCpuClient;
import zw.co.tapiwajoel.zombies.models.RobotCpu;
import zw.co.tapiwajoel.zombies.utils.dtos.ServiceResponse;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RobotCpuServiceImpl implements RobotCpuService {

    private final RobotCpuClient robotCpuClient;

    @Override
    public ServiceResponse<List<RobotCpu>> getRobots() {

        log.info("robotCpuClient.getAccountDetails() :::: [{}]", robotCpuClient.getAccountDetails());
        return ServiceResponse.<List<RobotCpu>>builder()
                .data(robotCpuClient.getAccountDetails())
                .message("RobotCPU retrieved successfully")
                .build();
    }
}
