package com.bsuir.ofeitus.archive.server.dao.parser.impl;

import com.bsuir.ofeitus.archive.server.dao.parser.XmlParser;
import com.bsuir.ofeitus.archive.server.dao.parser.XmlParserException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlStudentParser implements XmlParser {
    public List<Map<String, String>> parse(File dbFile) throws XmlParserException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(dbFile);
        NodeList students = document.getElementsByTagName("student");

        List<Map<String, String>> studentsParams = new ArrayList<>();

        for (int i = 0; i < students.getLength(); i++) {
            Map<String, String> studentParams = new HashMap<>();
            NodeList student = students.item(i).getChildNodes();
            studentParams.put("id", ((Element)students.item(i)).getAttribute("id"));
            for (int j = 0; j < student.getLength(); j++) {
                studentParams.put(student.item(j).getNodeName(), student.item(j).getTextContent());
            }
            studentsParams.add(studentParams);
        }

        return studentsParams;
    }
}
