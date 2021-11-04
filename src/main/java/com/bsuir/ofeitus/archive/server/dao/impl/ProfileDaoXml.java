package com.bsuir.ofeitus.archive.server.dao.impl;

import com.bsuir.ofeitus.archive.bean.Profile;
import com.bsuir.ofeitus.archive.server.dao.ProfileDao;
import com.bsuir.ofeitus.archive.server.dao.ServerDaoException;
import com.bsuir.ofeitus.archive.server.dao.parser.XmlParser;
import com.bsuir.ofeitus.archive.server.dao.parser.XmlParserException;
import com.bsuir.ofeitus.archive.server.dao.parser.impl.XmlProfileParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProfileDaoXml implements ProfileDao {
    private final File dbFile = new File(
            Objects.requireNonNull(getClass().getClassLoader().getResource("profiles.xml")).getFile());

    @Override
    public Profile loginProfile(String login, String hash) throws ServerDaoException {
        try {
            XmlParser parser = new XmlProfileParser();
            List<Map<String, String>> profileParams = parser.parse(dbFile);
            for (Map<String, String> params : profileParams) {
                if (params.get("login").equals(login) && params.get("password").equals(hash)) {
                    return new Profile(params);
                }
            }
            return new Profile();
        } catch (XmlParserException | ParserConfigurationException | IOException | SAXException e) {
            throw new ServerDaoException(e);
        }
    }
}
