package com.example.kenneth.thisforthat;

import android.content.Context;

public class AndroidContext {
    private static Context s_oContext;

    public static synchronized void setContext( Context oContext ){
        s_oContext = oContext;
    }

    public static synchronized Context getContext() {
        return s_oContext;
    }
}

