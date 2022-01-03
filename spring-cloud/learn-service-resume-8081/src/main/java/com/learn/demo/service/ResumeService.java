package com.learn.demo.service;

import com.lagou.edu.pojo.Resume;

public interface ResumeService {

    Resume findDefaultResumeByUserId(Long userId);
}
