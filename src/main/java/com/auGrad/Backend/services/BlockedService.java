package com.auGrad.Backend.services;


import com.auGrad.Backend.model.Blocked;
import com.auGrad.Backend.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlockedService {


    Blocked createBlocked(Blocked blocked);


    void updateBlockedForInterviewScheduledfunc(Blocked updateBlocked);

    List<Blocked> getBlocked();

    Blocked getBlockedByBatchId(int batchId);

    List<Integer> getEligibleGrads(Blocked checkEligibility);
}
