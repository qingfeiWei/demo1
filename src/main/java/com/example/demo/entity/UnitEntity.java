package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

public class UnitEntity {
    private String ID;
    private String NAME;
    private String firstChar;
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getNAME() {
        return NAME;
    }
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
    public String getFirstChar() {
        return firstChar;
    }
    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
}
