package ni.ki.ui.mainmodule.fragment.histroyFragmentModule;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ni.ki.BR;

import ni.ki.R;
import ni.ki.ViewModelProviderFactory;
import ni.ki.data.local.db.AppDatabase;
import ni.ki.data.model.db.HistoryDaoEntity;
import ni.ki.databinding.FragmentHistoryBinding;
import ni.ki.ui.base.BaseFragment;
import ni.ki.ui.mainmodule.Coordinates;
import ni.ki.ui.mainmodule.fragment.histroyFragmentModule.adapter.HistroyFragmentAdapter;


public class HistoryFragment extends BaseFragment<FragmentHistoryBinding, HistoryFragmentViewModel> implements HistoryFragmentNavigator {

    View view;
    @Inject
    ViewModelProviderFactory factory;
    private HistoryFragmentViewModel histroyFragmentViewModel;
    private FragmentHistoryBinding fragmentHistoryBinding;
    private Context mContext;
    List<HistoryDaoEntity> coordinatesHistoryList = new ArrayList<>();
    List<Coordinates> arrayList = new ArrayList<>();
    HistroyFragmentAdapter histroyFragmentAdapter;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_history;
    }

    @Override
    public HistoryFragmentViewModel getViewModel() {
        histroyFragmentViewModel = ViewModelProviders.of(this, factory).get(HistoryFragmentViewModel.class);
        return histroyFragmentViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentHistoryBinding = getViewDataBinding();
        histroyFragmentViewModel.setNavigator(this);
        mContext = getActivity();
        initView();

    }


    public void initView() {
        coordinatesHistoryList.clear();
        arrayList.clear();
        coordinatesHistoryList = AppDatabase.getDatabase(mContext).interfaceDao().getAllCoordinteHistory();
        String data = "";
        for (int i = 0; i < coordinatesHistoryList.size(); i++) {
            data = coordinatesHistoryList.get(i).getHistory_cordinates();
            Gson gson = new Gson();
            arrayList.addAll(gson.fromJson(data, new TypeToken<List<Coordinates>>() {
            }.getType()));

        }


        histroyFragmentAdapter = new HistroyFragmentAdapter(arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        fragmentHistoryBinding.recyclerCoordinates.setLayoutManager(mLayoutManager);
        fragmentHistoryBinding.recyclerCoordinates.setItemAnimator(new DefaultItemAnimator());
        fragmentHistoryBinding.recyclerCoordinates.setAdapter(histroyFragmentAdapter);


    }

}
