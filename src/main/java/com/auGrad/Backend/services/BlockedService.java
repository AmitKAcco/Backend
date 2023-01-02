package com.auGrad.Backend.services;


import com.auGrad.Backend.model.Blocked;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BlockedService {


    Blocked createBlocked(Blocked blocked);

    List<Blocked> getBlocked();

    Blocked getBlockedByBatchId(int batchId);
}
