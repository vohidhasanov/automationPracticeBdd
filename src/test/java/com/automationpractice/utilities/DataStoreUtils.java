package com.automationpractice.utilities;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public final class DataStoreUtils {
    private DataStoreUtils () { }

    private static Map<String, Object> dataStore;

    public static void storeData (String key, Object object) {
        if (dataStore == null) dataStore = new Hashtable<>();
            dataStore.put(key, object);
    }

    public static Object getObject (String key) {
        return dataStore.get(key);
    }

    public static String getObjectAsString (String key) {
        return getObject(key).toString();
    }

    public static Map <Integer, List<String>> getObjectAsMap (String key) {
        return (Map <Integer, List<String>>) getObject(key);
    }

}
