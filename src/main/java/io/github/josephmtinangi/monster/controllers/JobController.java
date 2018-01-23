package io.github.josephmtinangi.monster.controllers;

import io.github.josephmtinangi.monster.models.Job;
import io.github.josephmtinangi.monster.repositories.JobRepository;
import io.github.josephmtinangi.monster.services.JobService;
import io.github.josephmtinangi.monster.utilities.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobService jobService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<?> index() {

        List<Job> jobs = jobRepository.findAll();

        return Helper.createResponse(true, jobs, null, HttpStatus.OK);
    }

    @RequestMapping(path = "/job-title/{letter}", method = RequestMethod.GET)
    public ResponseEntity<?> jobTitle(@PathVariable String letter) {

        List<Job> jobs = jobService.whereTitleStartsWith(letter);

        return Helper.createResponse(true, jobs, null, HttpStatus.OK);
    }
}
