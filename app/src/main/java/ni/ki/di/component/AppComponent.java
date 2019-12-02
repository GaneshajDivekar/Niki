package ni.ki.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import ni.ki.application.NikiApplication;
import ni.ki.di.builder.ActivityBuilder;
import ni.ki.di.module.AppModule;

/**
 * Created by Ganesh Divekar on 06/11/19.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(NikiApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
