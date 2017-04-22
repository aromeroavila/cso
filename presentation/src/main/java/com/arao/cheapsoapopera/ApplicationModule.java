package com.arao.cheapsoapopera;

import android.content.Context;

import com.arao.cheapsoapopera.injection.qualifier.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    @ApplicationContext
    Context context(CsoApplication csoApplication) {
        return csoApplication.getApplicationContext();
    }

}
