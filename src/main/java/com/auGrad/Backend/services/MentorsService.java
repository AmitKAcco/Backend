package com.auGrad.Backend.services;

import com.auGrad.Backend.model.Mentors;

import java.util.List;

public interface MentorsService {
    Mentors createMentor(Mentors mentors);

    List<Mentors> getMentors();
}
