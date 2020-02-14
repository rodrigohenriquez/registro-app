package com.registro.registroapp.service.util;

import java.util.Calendar;
import java.util.Date;

public class DateCalendar {

    public static Date now(){
        Calendar currentDate = Calendar.getInstance();
        return new Date(currentDate.getTimeInMillis());
    }
}
