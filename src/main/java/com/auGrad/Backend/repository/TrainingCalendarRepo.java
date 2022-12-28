package com.auGrad.Backend.repository;

import com.auGrad.Backend.model.TrainingCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingCalendarRepo extends JpaRepository<TrainingCalendar,Integer> {
    Object findTopicByTopicId(String trainingTopicName);
//    Object findByTopicName(String trainingTopicName);
//    @Query("Select i from Inventory i where i.bookName=?1")
//    List<> findInventoryByBookName(String bookName);

}
