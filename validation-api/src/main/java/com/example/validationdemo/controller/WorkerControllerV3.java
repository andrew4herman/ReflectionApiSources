package com.example.validationdemo.controller;

import com.example.validationdemo.model.WorkerV3;
import com.example.validationdemo.validation.groups.Create;
import com.example.validationdemo.validation.groups.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3")
public class WorkerControllerV3 {

    @PostMapping("/workers")
    public ResponseEntity<WorkerV3> addWorker(@Validated(Create.class) @RequestBody WorkerV3 workerV3) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(workerV3);
    }

    @PutMapping("/workers")
    public ResponseEntity<WorkerV3> updateWorker(@Validated(Update.class) @RequestBody WorkerV3 workerV3) {
        return ResponseEntity.ok()
                .body(workerV3);
    }
}
