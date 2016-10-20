package com.gettyimages.downloadimages;

/**
 * Created by jsantos on 10/18/16.
 */
public class Context {

    private Context(){}

    private static class ContextHelper {
        private static final Context INSTANCE = new Context();
    }

    public static Context getInstance() {
        return ContextHelper.INSTANCE;
    }
}
