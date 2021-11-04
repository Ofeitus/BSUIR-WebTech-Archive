package com.bsuir.ofeitus.archive.server.service.impl;

import com.bsuir.ofeitus.archive.bean.Student;
import com.bsuir.ofeitus.archive.server.dao.ServerDaoException;
import com.bsuir.ofeitus.archive.server.dao.StudentDaoFactory;
import com.bsuir.ofeitus.archive.server.service.ServerService;
import com.bsuir.ofeitus.archive.server.service.ServerServiceException;

import java.util.List;

public class StudentServerService implements ServerService {
    public StudentServerService() {
    }

    @Override
    public List<Student> get(String id) throws ServerServiceException {
        try {
            return StudentDaoFactory.getInstance().getStudentDAO().get(id);
        } catch (ServerDaoException e) {
            throw new ServerServiceException(e);
        }
    }

    @Override
    public List<Student> getAll() throws ServerServiceException {
        try {
            return StudentDaoFactory.getInstance().getStudentDAO().getAll();
        } catch (ServerDaoException e) {
            throw new ServerServiceException(e);
        }
    }

    @Override
    public void add(Student student) throws ServerServiceException {
        try {
            StudentDaoFactory.getInstance().getStudentDAO().add(student);
        } catch (ServerDaoException e) {
            throw new ServerServiceException(e);
        }
    }

    @Override
    public void edit(Student student) throws ServerServiceException {
        try {
            StudentDaoFactory.getInstance().getStudentDAO().edit(student);
        } catch (ServerDaoException e) {
            throw new ServerServiceException(e);
        }
    }
}
