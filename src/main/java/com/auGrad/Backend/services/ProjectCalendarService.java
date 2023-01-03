package com.auGrad.Backend.services;

import com.auGrad.Backend.model.ProjectCalendar;

import java.util.List;

public interface ProjectCalendarService {
    ProjectCalendar createProjectCalendar(ProjectCalendar projectCalendar);

    List<ProjectCalendar> getProjectCalendar();

    List<ProjectCalendar> getProjectCalendarByBatchId(int batchId);
}
