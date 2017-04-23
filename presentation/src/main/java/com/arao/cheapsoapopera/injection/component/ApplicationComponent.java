package com.arao.cheapsoapopera.injection.component;

import android.content.Context;

import com.arao.cheapsoapopera.ApplicationModule;
import com.arao.cheapsoapopera.CsoApplication;
import com.arao.cheapsoapopera.injection.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(CsoApplication application);

        ApplicationComponent build();
    }

    @ApplicationContext
    Context context();

}
