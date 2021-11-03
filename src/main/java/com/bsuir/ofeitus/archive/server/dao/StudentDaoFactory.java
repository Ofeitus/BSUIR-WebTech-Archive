package com.bsuir.ofeitus.archive.server.dao;

import com.bsuir.ofeitus.archive.server.dao.impl.StudentDaoXml;

public class StudentDaoFactory {
    private static final StudentDaoFactory instance = new StudentDaoFactory();

    private final StudentDao studentDAO = new StudentDaoXml();

    private StudentDaoFactory() {

    }

    public StudentDao getStudentDAO() {
        return studentDAO;
    }

    public static StudentDaoFactory getInstance() {
        return instance;
    }
}
