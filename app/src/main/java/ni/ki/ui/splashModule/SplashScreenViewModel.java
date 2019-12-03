package ni.ki.ui.splashModule;

import ni.ki.data.DataManager;
import ni.ki.ui.base.BaseViewModel;
import ni.ki.utili.rx.SchedulerProvider;

public class SplashScreenViewModel extends BaseViewModel<SplashScreenNavigator> {
    public SplashScreenViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
