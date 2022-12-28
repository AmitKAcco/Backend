package com.auGrad.Backend.controller;

import com.auGrad.Backend.exception.NoObjectFoundException;
import com.auGrad.Backend.model.MockInterview;
import com.auGrad.Backend.services.MockInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MockInterviewController {
    @Autowired
    private MockInterviewService mockInterviewService;

    @PostMapping("/addMockInterview")
    private ResponseEntity<MockInterview> saveMockInterview(@RequestBody MockInterview mockInterview){
        try{
            return ResponseEntity.ok().body(this.mockInterviewService.createMockInterview(mockInterview));
        }
        catch (Exception e){
            throw new NoObjectFoundException("Mock Interview doesn't exist");
        }
    }
    @GetMapping("/allMockInterview")
    private ResponseEntity<List<MockInterview>> getAllMockInterview(){
        return ResponseEntity.ok().body(this.mockInterviewService.getMockInterview());
    }
}
