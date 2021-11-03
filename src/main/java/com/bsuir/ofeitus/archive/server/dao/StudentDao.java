package com.bsuir.ofeitus.archive.server.dao;

import com.bsuir.ofeitus.archive.bean.Student;

import java.util.List;

public interface StudentDao {
    List<Student> get(String id) throws ServerDaoException;

    List<Student> getAll() throws ServerDaoException;

    void add(Student appliance) throws ServerDaoException;

    void edit(Student student) throws ServerDaoException;
}
