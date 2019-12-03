package ni.ki;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import ni.ki.data.DataManager;
import ni.ki.ui.mainmodule.MainViewModel;
import ni.ki.ui.mainmodule.fragment.drawfragmentModule.DrawFragmentViewModel;
import ni.ki.ui.mainmodule.fragment.histroyFragmentModule.HistroyFragmentViewModel;
import ni.ki.utili.rx.SchedulerProvider;


public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(dataManager, schedulerProvider);
        }else if(modelClass.isAssignableFrom(DrawFragmentViewModel.class)){
            return (T) new DrawFragmentViewModel(dataManager, schedulerProvider);
        }else if(modelClass.isAssignableFrom(HistroyFragmentViewModel.class)){
            return (T) new HistroyFragmentViewModel(dataManager, schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}