package com.auGrad.Backend.services;

import com.auGrad.Backend.model.CheckBlocked;

import java.util.List;

public interface CheckBlockedService {
    CheckBlocked createCheckBlocked(CheckBlocked checkBlocked);

    List<CheckBlocked> getCheckedBlocked();

    CheckBlocked getCheckedBlockedByBatchId(int batchId);
}
