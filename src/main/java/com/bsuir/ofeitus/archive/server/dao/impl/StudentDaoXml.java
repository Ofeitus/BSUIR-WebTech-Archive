package com.bsuir.ofeitus.archive.server.dao.impl;

import com.bsuir.ofeitus.archive.bean.Student;
import com.bsuir.ofeitus.archive.server.dao.ServerDaoException;
import com.bsuir.ofeitus.archive.server.dao.StudentDao;
import com.bsuir.ofeitus.archive.server.dao.parser.XmlParser;
import com.bsuir.ofeitus.archive.server.dao.parser.XmlParserException;
import com.bsuir.ofeitus.archive.server.dao.parser.impl.XmlStudentParser;
import com.bsuir.ofeitus.archive.server.dao.writer.StudentWriter;
import com.bsuir.ofeitus.archive.server.dao.writer.XmlWriterException;
import com.bsuir.ofeitus.archive.server.dao.writer.impl.XmlStudentWriter;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class StudentDaoXml implements StudentDao {
    private final File dbFile = new File(
            Objects.requireNonNull(getClass().getClassLoader().getResource("db.xml")).getFile());
    private final File schemaFile = new File(
            Objects.requireNonNull(getClass().getClassLoader().getResource("db.xsd")).getFile());

    public List<Student> get(String id) throws ServerDaoException {
        List<Student> students = new ArrayList<>();
        try {
            XmlParser parser = new XmlStudentParser();
            List<Map<String, String>> studentsParams = parser.parse(dbFile);
            for (Map<String, String> params : studentsParams) {

                if (params.get("id").equals(id)) {
                    students.add(new Student(params));
                } 
            }
            return students;
        } catch (XmlParserException | ParserConfigurationException | IOException | SAXException | ParseException e) {
            throw new ServerDaoException(e);
        }
    }

    @Override
    public List<Student> getAll() throws ServerDaoException {
        List<Student> students = new ArrayList<>();
        try {
            XmlParser parser = new XmlStudentParser();
            List<Map<String, String>> studentsParams = parser.parse(dbFile);
            for (Map<String, String> params : studentsParams) {
                students.add(new Student(params));
            }
            return students;
        } catch (XmlParserException | ParserConfigurationException | IOException | SAXException | ParseException e) {
            throw new ServerDaoException(e);
        }
    }

    @Override
    public void add(Student student) throws ServerDaoException {
        try {
            StudentWriter xmlStudentWriter = new XmlStudentWriter();
            xmlStudentWriter.append(dbFile, schemaFile, student);
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException | XmlWriterException e) {
            throw new ServerDaoException(e);
        }
    }

    @Override
    public void edit(Student student) throws ServerDaoException {
        try {
            StudentWriter xmlStudentWriter = new XmlStudentWriter();
            xmlStudentWriter.replace(dbFile, schemaFile, student);
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException | XmlWriterException e) {
            throw new ServerDaoException(e);
        }
    }
}
