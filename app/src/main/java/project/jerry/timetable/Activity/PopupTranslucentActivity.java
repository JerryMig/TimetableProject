package project.jerry.timetable.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import project.jerry.timetable.Fragment.BaseFragment;
import project.jerry.timetable.Fragment.FirstPageOfMenuFragment;
import project.jerry.timetable.Fragment.MenuPagerFragment;
import project.jerry.timetable.Fragment.SecondPageOfMenuFragment;
import project.jerry.timetable.R;

/**
 * Created by Migme_Jerry on 2017/4/11.
 */

public class PopupTranslucentActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);
        initFragmentPage();
    }

    private void initFragmentPage() {
        BaseFragment pagerFragment = new MenuPagerFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.setCustomAnimations(R.anim.slide_in_top, R.anim.slide_out_top);
        transaction.replace(R.id.frame_container, pagerFragment);
        transaction.commit();
    }

}
