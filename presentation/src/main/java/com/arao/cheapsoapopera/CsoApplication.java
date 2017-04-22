package com.arao.cheapsoapopera;

import android.app.Application;
import android.content.Context;

import com.arao.cheapsoapopera.injection.component.ApplicationComponent;
import com.arao.cheapsoapopera.injection.component.DaggerApplicationComponent;

public class CsoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    public static CsoApplication get(Context context) {
        return (CsoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .application(this)
                .build();
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

}
