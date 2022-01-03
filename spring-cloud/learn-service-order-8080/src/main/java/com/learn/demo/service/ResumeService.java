package com.learn.demo.service;


import com.learn.demo.pojo.Resume;

public interface ResumeService {

    Resume findDefaultResumeByUserId(Long userId);
}
