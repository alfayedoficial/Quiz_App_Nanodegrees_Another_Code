package com.alialfayed.quizapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import static com.alialfayed.quizapp.util.Constants.COUNTER_Correct;
import static com.alialfayed.quizapp.util.Constants.COUNTER_WRONG;
import static com.alialfayed.quizapp.util.Constants.FIRST_ONE;
import static com.alialfayed.quizapp.util.Constants.NAME_USER;
import static com.alialfayed.quizapp.util.Constants.SH_QUIZ;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : Save Value in SharedPreferences
 * Date 4/29/2020 - 4:28 AM
 */
public class SaveSharedPreferences {

    public static int counterCorrect = 0;
    public static int counterWrong = 0;

    private static SharedPreferences preferences(Context context) {
        return context.getSharedPreferences(SH_QUIZ, 0);
    }

    public static void saveCounterCorrect(int counter, Context context) {
        preferences(context).edit()
                .putInt(COUNTER_Correct, counter).apply();
    }

    public static Integer getCounterCorrect(Context context) {
        return preferences(context).getInt(COUNTER_Correct, 0);
    }

    public static void saveCounterWrong(int counter, Context context) {
        preferences(context).edit()
                .putInt(COUNTER_WRONG, counter).apply();
    }

    public static Integer getCounterWrong(Context context) {
        return preferences(context).getInt(COUNTER_WRONG, 0);
    }

    public static void saveNameUser(String name, Context context) {
        preferences(context).edit()
                .putString(NAME_USER, name).apply();
    }

    public static String getNameUser(Context context) {
        return preferences(context).getString(NAME_USER, SH_QUIZ);
    }

    public static void saveFirstOnce(Boolean firstOne, Context context) {
        preferences(context).edit()
                .putBoolean(FIRST_ONE, firstOne).apply();
    }

    public static boolean getFirstOnce(Context context) {
        return preferences(context).getBoolean(FIRST_ONE, false);
    }
}
