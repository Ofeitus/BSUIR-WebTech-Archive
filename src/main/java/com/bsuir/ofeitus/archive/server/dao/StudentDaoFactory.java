package com.bsuir.ofeitus.archive.server.dao;

import com.bsuir.ofeitus.archive.server.dao.impl.ProfileDaoXml;
import com.bsuir.ofeitus.archive.server.dao.impl.StudentDaoXml;
import com.bsuir.ofeitus.archive.server.service.ProfileServerService;

public class StudentDaoFactory {
    private static final StudentDaoFactory instance = new StudentDaoFactory();

    private final StudentDao studentDAO = new StudentDaoXml();
    private final ProfileDao profileDAO = new ProfileDaoXml();

    private StudentDaoFactory() {

    }

    public StudentDao getStudentDAO() {
        return studentDAO;
    }

    public static StudentDaoFactory getInstance() {
        return instance;
    }

    public ProfileDao getProfileDAO() {
        return profileDAO;
    }
}
