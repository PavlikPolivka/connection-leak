package com.ppolivka.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;
import java.sql.SQLException;

@Controller
public class LeakController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping(value = "/leak", method = RequestMethod.GET)
    public String leakConnection() throws SQLException {
        dataSource.getConnection();
        return "leak";
    }

}
