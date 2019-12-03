package ni.ki.ui.mainmodule.fragment.drawfragmentModule;


import android.content.Context;

import ni.ki.data.DataManager;
import ni.ki.ui.base.BaseViewModel;
import ni.ki.utili.rx.SchedulerProvider;

public class DrawFragmentViewModel extends BaseViewModel<DrawFragmentNavigator> {

    public DrawFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);

    }

    public void clickOnDraw() {
        getNavigator().clickOnDraw();
    }
    public void clickSelect() {
        getNavigator().clickOnSelect();
    }

    public void clickOnPrint() {
        getNavigator().clickOnPrint();
    }
    public  void clickOnSave(){
        getNavigator().clickOnSave();
    }

}