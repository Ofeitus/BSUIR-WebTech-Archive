package com.bsuir.ofeitus.archive.server.controller;

import com.bsuir.ofeitus.archive.bean.Profile;

public interface ServerController {
    String doAction(String request, Profile profile);
}
