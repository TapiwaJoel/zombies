package zw.co.tapiwajoel.zombies.service;

import zw.co.tapiwajoel.zombies.models.ReportContamination;
import zw.co.tapiwajoel.zombies.utils.dtos.ServiceResponse;

public interface ReportContaminationService {
    /**
     * Request to survivor.
     *
     * @param survivorId survivorId
     * @return { boolean}
     */
    ServiceResponse<ReportContamination> reportContamination(long survivorId);
}
