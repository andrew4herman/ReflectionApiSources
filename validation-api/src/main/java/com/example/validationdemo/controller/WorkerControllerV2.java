package com.example.validationdemo.controller;

import com.example.validationdemo.model.WorkerV1;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

@Validated
@RestController
@RequestMapping("/v2")
public class WorkerControllerV2 {

    @GetMapping("/workers")
    public ResponseEntity<String> getWorkers(@RequestParam("code") @Pattern(regexp = "[0-9]{1,3}") String code) {
        return ResponseEntity.ok("Worker code is valid.");
    }

    @GetMapping("/workers/{id}")
    public ResponseEntity<String> getWorkerById(@PathVariable("id") @Min(1) int id) {
        return ResponseEntity.ok("Worker id is valid.");
    }

    @PostMapping("/workers")
    public ResponseEntity<String> addWorker(@RequestBody List<@Valid WorkerV1> workerV1s) {
        return ResponseEntity.ok("All workers have valid info.");
    }

}
