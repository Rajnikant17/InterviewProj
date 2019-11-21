package enrich.newproject.intervproj.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import enrich.newproject.intervproj.DI.ViewModelProviderFactory;
import enrich.newproject.intervproj.R;
import enrich.newproject.intervproj.databinding.ActivityMainBinding;
import enrich.newproject.intervproj.model.Dataum;
import enrich.newproject.intervproj.model.ModelData;
import enrich.newproject.intervproj.ui.adapter.ViewPagerAdapter;
import enrich.newproject.intervproj.utils.CustomSnackBar;
import enrich.newproject.intervproj.utils.Listener;
import enrich.newproject.intervproj.viewModels.MainActivityViewModel;

public class MainActivity extends DaggerAppCompatActivity implements Listener {
    @Inject
    ViewModelProviderFactory providerFactory;
    MainActivityViewModel mainActivityViewModel;
    ViewPagerAdapter viewPagerAdapter;
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainActivityViewModel= ViewModelProviders.of(this,providerFactory).get(MainActivityViewModel.class);
        mainActivityViewModel.listener=this;
        mainActivityViewModel.fetchcardViewContent(this);
    }

    @Override
    public void onStartProgress() {
        showProgressbar();
    }

    @Override
    public void onSuccess(ModelData modelData) {
        hideProgressbar();
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),modelData.getData());
        activityMainBinding.viewPager.setAdapter(viewPagerAdapter);
        activityMainBinding.viewPager.setPageMargin(36);
        activityMainBinding.indicator.setupWithViewPager(activityMainBinding.viewPager, true);
    }

    @Override
    public void onError(String msg) {
        hideProgressbar();
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void noInternetConnection(String msg) {
        hideProgressbar();
        CustomSnackBar snackBar=new CustomSnackBar();
        snackBar.customSnackbar(activityMainBinding.parentlayout,msg,this);
    }

    @Override
    public void noDataFound(String msg) {
        CustomSnackBar snackBar=new CustomSnackBar();
        snackBar.customSnackbar(activityMainBinding.parentlayout,msg,this);
    }

    public  void showProgressbar()
    {
        activityMainBinding.progressBar.setVisibility(View.VISIBLE);
        activityMainBinding.progressBar.show();
    }

    public  void hideProgressbar()
    {
        activityMainBinding.progressBar.setVisibility(View.GONE);
        activityMainBinding.progressBar.hide();
    }
}
