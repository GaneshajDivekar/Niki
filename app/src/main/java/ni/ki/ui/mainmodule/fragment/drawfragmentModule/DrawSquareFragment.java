package ni.ki.ui.mainmodule.fragment.drawfragmentModule;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import ni.ki.R;
import ni.ki.ViewModelProviderFactory;
import ni.ki.databinding.FragmentDrawsquareBinding;
import ni.ki.ui.base.BaseFragment;
import ni.ki.BR;


public class DrawSquareFragment extends BaseFragment<FragmentDrawsquareBinding,DrawFragmentViewModel>implements DrawFragmentNavigator {

    View view;
    @Inject
    ViewModelProviderFactory factory;
    private DrawFragmentViewModel drawFragmentViewModel;
    private FragmentDrawsquareBinding fragmentDrawsquareBinding;
    private Context mContext;


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_drawsquare;
    }

    @Override
    public DrawFragmentViewModel getViewModel() {

        drawFragmentViewModel = ViewModelProviders.of(this, factory).get(DrawFragmentViewModel.class);
        return drawFragmentViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentDrawsquareBinding = getViewDataBinding();
        initView();

    }


    public void initView() {
        mContext = getActivity();
    }

    private void initData() {


    }


}
