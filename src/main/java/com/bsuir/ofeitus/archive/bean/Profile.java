package com.bsuir.ofeitus.archive.bean;

import java.util.Map;
import java.util.Objects;

public class Profile {
    private String login;
    private String password;
    private Rights rights;

    public Profile() {
        this.login = "";
        this.password = "";
        this.rights = Rights.GUEST;
    }

    public Profile(Map<String, String> params) {
        setLogin(params.get("login"));
        setPassword(params.get("password"));
        setRights(Rights.valueOf(params.get("rights")));
    }

    public Profile(String login, String password, Rights rights) {
        this.login = login;
        this.password = password;
        this.rights = rights;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return login.equals(profile.login) && password.equals(profile.password) && rights == profile.rights;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, rights);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", rights=" + rights +
                '}';
    }
}
