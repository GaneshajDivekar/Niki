package ni.ki.di.builder;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ni.ki.ui.mainmodule.MainActivity;
import ni.ki.ui.mainmodule.fragment.drawfragmentModule.DrawFragmentProvider;
import ni.ki.ui.mainmodule.fragment.histroyFragmentModule.HistoryFragmentProvider;
import ni.ki.ui.splashModule.SplashScreenActivity;

/**
 * Created by Ganesh Divekar on 06/11/19.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules={
            DrawFragmentProvider.class,
            HistoryFragmentProvider.class
    })
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract SplashScreenActivity bindSplashScreenActivity();
}
