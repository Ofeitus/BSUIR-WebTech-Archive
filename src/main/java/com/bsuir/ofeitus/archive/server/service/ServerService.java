package com.bsuir.ofeitus.archive.server.service;

import com.bsuir.ofeitus.archive.bean.Student;

import java.util.List;

public interface ServerService {
    List<Student> get(String id) throws ServerServiceException;

    List<Student> getAll() throws ServerServiceException;

    void add(Student student) throws ServerServiceException;

    void edit(Student student) throws ServerServiceException;
}
