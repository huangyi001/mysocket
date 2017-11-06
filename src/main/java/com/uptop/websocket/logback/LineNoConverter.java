package com.uptop.websocket.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;


/**
 * Created by ASUS on 2017-11-02.
 */

public class LineNoConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        try {
            StackTraceElement[] cda = event.getCallerData();
            if (cda != null && cda.length > 0) {
                return cda[0].toString();
            }
            return "";
        }
        catch (Exception e) {
            return "";
        }
    }
}
