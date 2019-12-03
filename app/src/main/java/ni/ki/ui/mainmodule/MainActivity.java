package ni.ki.ui.mainmodule;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import ni.ki.BR;
import ni.ki.R;
import ni.ki.ViewModelProviderFactory;
import ni.ki.databinding.ActivityMainBinding;
import ni.ki.ui.base.BaseActivity;
import ni.ki.ui.mainmodule.adapter.ActivatePagerAdapter;
import ni.ki.ui.mainmodule.fragment.drawfragmentModule.DrawSquareFragment;
import ni.ki.ui.mainmodule.fragment.histroyFragmentModule.HistoryFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProviderFactory factory;
    private TextView notificationTextCount, notificationTextCount2;
    private RelativeLayout rlForCountForBadge1, rlForCountForBadge2;
    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;
    private ActivatePagerAdapter adapter;
    private Context context;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        mainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        return mainViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = getViewDataBinding();
        mainViewModel.setNavigator(this);
        initView();
    }

    private void initView() {
        context = MainActivity.this;

        adapter = new ActivatePagerAdapter(getSupportFragmentManager());

        adapter.addFrag(new DrawSquareFragment(), "Draw Square");
        adapter.addFrag(new HistoryFragment(), "History");
        activityMainBinding.viewpager.setAdapter(adapter);
        activityMainBinding.tabs.setupWithViewPager(activityMainBinding.viewpager);

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
