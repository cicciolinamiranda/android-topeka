package com.google.samples.apps.topeka.room;


import android.arch.persistence.room.TypeConverter;

import com.google.samples.apps.topeka.model.Theme;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Arrays;

public class Converters {
    @TypeConverter
    public static String themeToString(Theme theme) {
        return theme.name();
    }

    @TypeConverter
    public static Theme stringToTheme(String themeName) {
        return Theme.valueOf(themeName);
    }

    @TypeConverter
    public static String scoreToString(int[] scores) {
        return Arrays.toString(scores);
    }

    @TypeConverter
    public static int[] stringToScores(String stringScore) {
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(stringScore);

            int[] intArray = new int[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {
                intArray[i] = jsonArray.getInt(i);
            }

            return intArray;
        } catch (JSONException e) {
            e.printStackTrace();

            return new int[10];
        }
    }
}
