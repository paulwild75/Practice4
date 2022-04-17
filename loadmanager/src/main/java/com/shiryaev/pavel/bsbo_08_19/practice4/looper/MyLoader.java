package com.shiryaev.pavel.bsbo_08_19.practice4.looper;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class MyLoader extends AsyncTaskLoader<String> {
    private String editString;
    public static final String ARG_WORD = "word";

    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null) {
            String s = args.getString(ARG_WORD);
            Log.d("EditString", s);
            StringBuilder shuffledString = new StringBuilder();
            while (s.length() != 0) {
                int index = (int) Math.floor(Math.random() * s.length());
                char c = s.charAt(index);
                s = s.substring(0, index) + s.substring(index + 1);
                shuffledString.append(c);
            }
            editString = shuffledString.toString();

        }
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @Nullable
    @Override
    public String loadInBackground() {
        SystemClock.sleep(2000);
        return editString;
    }
}
