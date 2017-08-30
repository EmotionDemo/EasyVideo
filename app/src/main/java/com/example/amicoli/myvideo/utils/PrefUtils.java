package com.example.amicoli.myvideo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.amicoli.myvideo.MyApp;

public class PrefUtils
{
  public static final String PRE_USER_INFO = "pref_setting_user";

  public static boolean getFromPrefsBool(String paramString)
  {
    return getSharedPreferences().getBoolean(paramString, false);
  }

  private static SharedPreferences getSharedPreferences()
  {
    return MyApp.getContext().getSharedPreferences("pref_setting_user", 0);
  }

  public static void removeFromPrefs(String paramString)
  {
    Editor localEditor = getSharedPreferences().edit();
    localEditor.remove(paramString);
    localEditor.commit();
  }

  public static void setSaveBool(String paramString, boolean paramBoolean)
  {
    Editor localEditor = getSharedPreferences().edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }

  public static void setSaveString(String paramString1, String paramString2)
  {
    Editor localEditor = getSharedPreferences().edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
}
