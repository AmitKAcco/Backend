package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Approval;
import com.auGrad.Backend.model.Batch;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AppovalService {
    Approval createApproval(Approval obj);

    Approval getApproval(Integer id);

    List<Approval> getALlApproval();
}
