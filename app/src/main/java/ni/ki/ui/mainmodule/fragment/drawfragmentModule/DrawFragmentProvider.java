package ni.ki.ui.mainmodule.fragment.drawfragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ni.ki.ui.base.BaseViewHolder;
import ni.ki.ui.base.BaseViewModel;
import ni.ki.utili.rx.SchedulerProvider;

@Module
public abstract class DrawFragmentProvider {
    @ContributesAndroidInjector
    abstract DrawSquareFragment provideAllFragmentFactory();

}


