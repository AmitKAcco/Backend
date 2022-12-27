package com.auGrad.Backend.services;


import com.auGrad.Backend.model.Blocked;

import java.util.List;

public interface BlockedService {


    Blocked createBlocked(Blocked blocked);

    List<Blocked> getBlocked();
}
