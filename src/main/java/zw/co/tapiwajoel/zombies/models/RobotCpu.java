package zw.co.tapiwajoel.zombies.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RobotCpu {
    private String model;
    private String serialNumber;
    private String manufacturedDate;
    private String category;
}
