package ni.ki.di.builder;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ni.ki.ui.mainmodule.MainActivity;

/**
 * Created by Ganesh Divekar on 06/11/19.
 */

@Module
public abstract class ActivityBuilder {


    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
