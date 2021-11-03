package com.bsuir.ofeitus.archive.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student implements Serializable, Parameterizable {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String id;
    private String name;
    private Date dateOfBirth;
    private String address;
    private float averageGrade;

    public Student() {
    }

    public Student(Map<String, String> params) throws ParseException {
        this.id = params.get("id");
        this.name = params.get("name");
        this.dateOfBirth = dateFormat.parse(params.get("dateOfBirth"));
        this.address = params.get("address");
        this.averageGrade = Float.parseFloat(params.get("averageGrade"));
    }

    public Student(String id, String name, Date dateOfBirth, String address, int averageGrade) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.averageGrade = averageGrade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(float averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                averageGrade == student.averageGrade &&
                name.equals(student.name) &&
                dateOfBirth.equals(student.dateOfBirth) &&
                address.equals(student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth, address, averageGrade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateFormat.format(dateOfBirth) +
                ", address='" + address + '\'' +
                ", averageGrade=" + averageGrade +
                '}';
    }

    @Override
    public Map<String, String> getParams() {
        return new HashMap<>() {{
            put("id", String.valueOf(id));
            put("name", name);
            put("dateOfBirth", dateFormat.format(dateOfBirth));
            put("address", address);
            put("averageGrade", String.valueOf(averageGrade));
        }};
    }
}
