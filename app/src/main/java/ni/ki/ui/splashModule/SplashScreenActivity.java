package ni.ki.ui.splashModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import javax.inject.Inject;

import ni.ki.BR;
import ni.ki.R;
import ni.ki.ViewModelProviderFactory;
import ni.ki.databinding.ActivitySplashScreenBinding;
import ni.ki.ui.base.BaseActivity;
import ni.ki.ui.mainmodule.MainActivity;

public class SplashScreenActivity extends BaseActivity<ActivitySplashScreenBinding,SplashScreenViewModel>implements SplashScreenNavigator {


    @Inject
    ViewModelProviderFactory factory;
    ActivitySplashScreenBinding activitySplashScreenBinding;
    SplashScreenViewModel splashScreenViewModel;
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash_screen;
    }

    @Override
    public SplashScreenViewModel getViewModel() {
        splashScreenViewModel = ViewModelProviders.of(this, factory).get(SplashScreenViewModel.class);
        return splashScreenViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySplashScreenBinding = getViewDataBinding();
        splashScreenViewModel.setNavigator(this);
        initView();
    }

    private void initView() {
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 1000);
    }


}
