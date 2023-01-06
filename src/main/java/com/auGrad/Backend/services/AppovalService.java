package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Approval;

import java.util.List;
import java.util.Optional;


public interface AppovalService {
    Approval createApproval(Approval obj);

    Optional<Approval> getApproval(String id);

    List<Approval> getALlApproval();
}
