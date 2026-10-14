package com.example.Jobapp.controller;

import com.example.Jobapp.model.JobPost;
import com.example.Jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobservice;

    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }
    @GetMapping("addjob")
    public String addJob(){
        return "addjob";
    }
    @GetMapping("viewalljobs")
    public String viewJobs(Model m) {
        List<JobPost> jobs = jobservice.getallJob();
        m.addAttribute("jobPosts", jobs);

        return "viewalljobs";
    }
    @PostMapping("handleForm")
    public String handleForm(JobPost jobpost){
        jobservice.addJob(jobpost);
        return "success";
    }



}
