package com.info.PropertyEditors;

import java.beans.PropertyEditorSupport;
import java.time.LocalTime;

public class CustomLocalTime extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        //09:30
        String[] timeArr=text.split(":");
        int hrs=Integer.parseInt(timeArr[0]);
        int mins=Integer.parseInt(timeArr[1]);
        LocalTime localTime=LocalTime.of(hrs,mins);
        setValue(localTime);
    }
}
