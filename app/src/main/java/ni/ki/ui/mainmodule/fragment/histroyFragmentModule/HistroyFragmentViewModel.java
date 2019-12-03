package ni.ki.ui.mainmodule.fragment.histroyFragmentModule;

import ni.ki.data.DataManager;
import ni.ki.ui.base.BaseViewModel;
import ni.ki.utili.rx.SchedulerProvider;

public class HistroyFragmentViewModel extends BaseViewModel<HistroyFragmentNavigator> {

    public HistroyFragmentViewModel(DataManager dataManager,SchedulerProvider schedulerProvider) {
        super( dataManager,schedulerProvider);

    }


}