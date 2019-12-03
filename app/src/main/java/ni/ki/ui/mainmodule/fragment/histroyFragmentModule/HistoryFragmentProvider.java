package ni.ki.ui.mainmodule.fragment.histroyFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;



@Module
public abstract class HistoryFragmentProvider {
    @ContributesAndroidInjector
    abstract HistoryFragment provideAllFragmentFactory();

}