package ni.ki.ui.mainmodule.fragment.histroyFragmentModule;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import ni.ki.BR;

import ni.ki.R;
import ni.ki.ViewModelProviderFactory;
import ni.ki.databinding.FragmentDrawsquareBinding;
import ni.ki.databinding.FragmentHistoryBinding;
import ni.ki.ui.base.BaseFragment;
import ni.ki.ui.mainmodule.fragment.drawfragmentModule.DrawFragmentViewModel;


public class HistoryFragment extends BaseFragment<FragmentHistoryBinding,HistroyFragmentViewModel>implements HistroyFragmentNavigator {

    View view;
    @Inject
    ViewModelProviderFactory factory;
    private HistroyFragmentViewModel histroyFragmentViewModel;
    private FragmentHistoryBinding fragmentHistoryBinding;
    private Context mContext;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_history;
    }

    @Override
    public HistroyFragmentViewModel getViewModel() {
        histroyFragmentViewModel = ViewModelProviders.of(this, factory).get(HistroyFragmentViewModel.class);
        return histroyFragmentViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentHistoryBinding = getViewDataBinding();
        initView();

    }


    public void initView() {
        mContext = getActivity();
    }

    private void initData() {


    }

}
