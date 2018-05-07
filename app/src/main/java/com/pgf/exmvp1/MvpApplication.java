package com.pgf.exmvp1;

import android.app.Application;

public class MvpApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
