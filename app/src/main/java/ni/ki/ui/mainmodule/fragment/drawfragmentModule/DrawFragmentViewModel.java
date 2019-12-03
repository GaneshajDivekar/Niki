package ni.ki.ui.mainmodule.fragment.drawfragmentModule;


import ni.ki.data.DataManager;
import ni.ki.ui.base.BaseViewModel;
import ni.ki.utili.rx.SchedulerProvider;

public class DrawFragmentViewModel extends BaseViewModel<DrawFragmentNavigator> {

    public DrawFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);

    }


}