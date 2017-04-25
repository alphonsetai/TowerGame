package com.xqs.mypaoku.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.xqs.mypaoku.util.Util;


/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class Prefs {

    public static final String PREFS_NAME = "my_prefs";

    public static final String SOUND = "sound";

    public static final String LEVEL = "level";

    public static Prefs getPrefs(){
        return new Prefs();
    }

    private static Preferences getInstance(){
        Preferences prefs = Gdx.app.getPreferences(PREFS_NAME);
        return prefs;
    }

    public void clear(){
        getInstance().clear();
    }

    // ------ sound state ------
    public void setSoundEffectsEnabled(boolean state){
        getInstance().putBoolean(SOUND,state).flush();
    }

    public boolean isSoundEffectsEnabled(){
        return getInstance().getBoolean(SOUND,true);
    }

    // --- passed leves ---
    public int getPassedLevel(){
        return getInstance().getInteger(LEVEL,0);
    }

    public void setPassedLevel(int level){
        int passed = getPassedLevel();
        if(level>passed){
            getInstance().putInteger(LEVEL,level).flush();
        }
    }
}
