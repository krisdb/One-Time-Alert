package com.krisdb.onetimealert;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

class SharedPreferencesHelper {

    public static boolean getBoolean(final Context context, final String key)
    {
        return getBoolean(context, key, false);
    }

    public static boolean getBoolean(final Context context, final String key, final boolean defaultValue)
    {
        return getPrefs(context).getBoolean(key, defaultValue);
    }

    public static Integer getStringInteger(final Context context, final String key)
    {
        return Integer.parseInt(getPrefs(context).getString(key, "0"));
    }

    public static String getString(final Context context, final String key)
    {
        return getPrefs(context).getString(key, null);
    }

    public static String getString(final Context context, final String key, final String defaultValue)
    {
        return getPrefs(context).getString(key, defaultValue);
    }

    public static Integer getInteger(final Context context, final String key)
    {
        return getPrefs(context).getInt(key, 0);
    }

    public static Integer getInteger(final Context context, final String key, final Integer defaultValue)
    {
        return getPrefs(context).getInt(key, defaultValue);
    }

    public static float getFloat(final Context context, final String key)
    {
        return getPrefs(context).getFloat(key, 0.0f);
    }

    public static float getFloat(final Context context, final String key, final Integer defaultValue)
    {
        return getPrefs(context).getFloat(key, defaultValue);
    }

    public static Set<String> getStringSet(final Context context, final String key)
    {
        return getStringSet(context, key, new HashSet<>());
    }

    public static Set<String> getStringSet(final Context context, final String key, final Set<String> defaultValue)
    {
        return getPrefs(context).getStringSet(key, defaultValue);
    }

    public static void put(final Context context, final String key, final Object object) {

        final SharedPreferences.Editor editor = getPrefs(context).edit();

        if (object == null)
            editor.putString(key,  null);
        else if (object instanceof String)
            editor.putString(key, (String) object);
        else if (object instanceof Integer)
            editor.putInt(key, (Integer) object);
        else if (object instanceof Boolean)
            editor.putBoolean(key, (Boolean) object);
        else if (object instanceof Float)
            editor.putFloat(key, (Float) object);
        else if (object instanceof Long)
            editor.putLong(key, (Long) object);
        else if (object instanceof Set<?>)
            editor.putStringSet(key, (Set<String>) object);
        else
            editor.putString(key, object.toString());

        editor.apply();
    }

    public static void remove(final Context context, final String key) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.remove(key);
        editor.apply();
    }

    private static SharedPreferences getPrefs(final Context context)
    {
        return context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }
}
