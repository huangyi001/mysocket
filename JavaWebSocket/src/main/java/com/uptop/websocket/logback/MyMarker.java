package com.uptop.websocket.logback;

import org.slf4j.Marker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by ASUS on 2017-11-02.
 */
public class MyMarker implements Marker {

    private static final long serialVersionUID = -1387951421362902419L;
    public static final String MARKER_NAME = "my_marker";

    /**
     * 日志跟踪id
     */

    public static String TRACE_LOG_ID = "TRACE_LOG_ID";

    /**
     * 其他信息
     */

    public static String OTHER_MSG = "OTHER_MSG";
    Map<MarkerKey, String> myMarkers;

    MyMarker(MarkerKey markerKey, String value) {
        this(new MarkerKey[] { markerKey }, new String[] { value });
    }

    MyMarker(MarkerKey[] markerKeys, String[] values) {
        myMarkers = new HashMap<MarkerKey, String>(markerKeys.length);
        String[] newValues = values;
        if (values.length < markerKeys.length) {
            newValues = new String[markerKeys.length];
            System.arraycopy(values, 0, newValues, 0, values.length);
            Arrays.fill(newValues, values.length, markerKeys.length, "");
        }
        for (int i = 0; i < markerKeys.length; i++) {
            myMarkers.put(markerKeys[i], newValues[i]);
        }
    }

    public void setMarkerKeys(MarkerKey[] markerKeys, String[] values) {
        String[] newValues = values;
        if (values.length < markerKeys.length) {
            newValues = new String[markerKeys.length];
            System.arraycopy(values, 0, newValues, 0, values.length);
            Arrays.fill(newValues, values.length, markerKeys.length, "");
        }
        for (int i = 0; i < markerKeys.length; i++) {
            myMarkers.put(markerKeys[i], newValues[i]);
        }
    }

    public Map<MarkerKey, String> getMyMarkers() {
        return myMarkers;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(80);
        Iterator<MarkerKey> ite = myMarkers.keySet().iterator();
        while (ite.hasNext()) {
            MarkerKey key = ite.next();
            sb.append("\"").append(key).append("\":\"").append(myMarkers.get(key)).append("\"");
            if (ite.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public enum MarkerKey {

        /**
         * 异常名称
         */

        EXNAME("EXNAME"),

        /**
         * 异常信息
         */

        EXMESSAGE("EXMESSAGE"),

        /**
         * 异常堆栈
         */

        EXSTACK("EXSTACK");

        String key;

        MarkerKey(String key) {
            this.key = key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    public String getName() {
        return MARKER_NAME;
    }

    @Deprecated
    public void add(Marker reference) {
        // NOP
    }

    @Deprecated
    public boolean remove(Marker reference) {
        // NOP
        return false;
    }

    @Deprecated
    public boolean hasChildren() {
        // NOP
        return false;
    }

    @Deprecated
    public boolean hasReferences() {
        // NOP
        return false;
    }

    @Deprecated
    public Iterator iterator() {
        // NOP
        return null;
    }

    @Deprecated
    public boolean contains(Marker other) {
        // NOP
        return false;
    }

    @Deprecated
    public boolean contains(String name) {
        // NOP
        return false;
    }

}
