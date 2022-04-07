package com.example.validationdemo.controller;

import com.example.validationdemo.model.WorkerV1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class WorkerControllerV1 {

    @PostMapping("/workers")
    public ResponseEntity<WorkerV1> addWorker(@Valid @RequestBody WorkerV1 workerV1) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(workerV1);
    }

}
