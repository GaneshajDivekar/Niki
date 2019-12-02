package ni.ki.ui.mainmodule;

import ni.ki.data.DataManager;
import ni.ki.ui.base.BaseViewModel;
import ni.ki.utili.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel<MainNavigator> {
    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}

