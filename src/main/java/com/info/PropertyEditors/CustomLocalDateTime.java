package com.info.PropertyEditors;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;

public class CustomLocalDateTime extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] dateTimeArr=text.split("T");
        String[] datesArr=dateTimeArr[0].split("-");
        String[] timeArr=dateTimeArr[1].split(":");

        int year=Integer.parseInt(datesArr[0]);
        int month=Integer.parseInt(datesArr[1]);
        int date=Integer.parseInt(datesArr[2]);
        int hrs=Integer.parseInt(timeArr[0]);
        int mins=Integer.parseInt(timeArr[1]);
        LocalDateTime localDateTime=LocalDateTime.of(year,month,date,hrs,mins);
        setValue(localDateTime);
    }
}
