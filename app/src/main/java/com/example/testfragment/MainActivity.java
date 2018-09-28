package com.example.testfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    private TextView vMyinfo;
    private TextView vSet;
    private TextView vInfo;
    private TextView vDate;
    private TextView vShow;
    private TextView vStorgge;
    private TextView vAdvance;
    private TextView vRestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vMyinfo = (TextView) findViewById(R.id.item_benji);
        vMyinfo.setOnFocusChangeListener(this);
        vSet = (TextView) findViewById(R.id.item_net_set);
        vSet.setOnFocusChangeListener(this);
        vInfo = (TextView)findViewById(R.id.item_net_info);
        vInfo.setOnFocusChangeListener(this);
        vDate = (TextView)findViewById(R.id.item_date);
        vDate.setOnFocusChangeListener(this);
        vShow = (TextView)findViewById(R.id.item_show);
        vShow.setOnFocusChangeListener(this);
        vStorgge = (TextView)findViewById(R.id.item_storage);
        vStorgge.setOnFocusChangeListener(this);
        vAdvance = (TextView)findViewById(R.id.item_advanced_set);
        vAdvance.setOnFocusChangeListener(this);
        vRestore = (TextView)findViewById(R.id.item_restore);
        vRestore.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View view, boolean hasfocus) {
        if (hasfocus) {
            switch (view.getId()) {
                case R.id.item_benji:
                    replaceFragment(new FragmentMyinfo());
                    break;
                case R.id.item_net_set:
                    replaceFragment(new FragmentNetSet());
                    break;
                case  R.id.item_net_info:
                    replaceFragment(new FragmentNetInfo());
                    break;
                case R.id.item_date:
                    replaceFragment(new FragmentDate());
                    break;
                case  R.id.item_show:
                    replaceFragment(new FragmentShow());
                    break;
                case R.id.item_storage:
                    replaceFragment(new FragmentStorage());
                    break;
                case R.id.item_advanced_set:
                    replaceFragment(new FregmentAdvance());
                    break;
                case R.id.item_restore:
                    replaceFragment(new FragmentRestore());
                    break;
                default:
                    break;
            }
        }else{
            boolean flag = menuItemIsFocused((TextView)view);
            if(flag){

            }else{
                    TextView focusLocation = (TextView)view;
                    focusLocation.setBackgroundResource(R.drawable.menu_item_select);

            }
        }
    }
    private boolean menuItemIsFocused(TextView nowItem) {
        TextView nextItem;
        TextView preItem;

        switch (nowItem.getId()) {
            case R.id.item_benji:
                nextItem = (TextView) findViewById(R.id.item_net_set);
                preItem = (TextView) findViewById(R.id.item_restore);
                break;

            case R.id.item_net_set:
                nextItem = (TextView) findViewById(R.id.item_net_info);
                preItem = (TextView) findViewById(R.id.item_benji);
                break;
            case R.id.item_net_info:
                nextItem = (TextView) findViewById(R.id.item_date);
                preItem = (TextView) findViewById(R.id.item_net_set);
                break;
            case R.id.item_date:
                nextItem = (TextView) findViewById(R.id.item_show);
                preItem = (TextView) findViewById(R.id.item_net_info);
                break;
            case R.id.item_show:
                nextItem = (TextView) findViewById(R.id.item_storage);
                preItem = (TextView) findViewById(R.id.item_date);
                break;
            case R.id.item_storage:
                nextItem = (TextView) findViewById(R.id.item_advanced_set);
                preItem = (TextView) findViewById(R.id.item_show);
                break;

            case R.id.item_advanced_set:
                nextItem = (TextView) findViewById(R.id.item_restore);
                preItem = (TextView) findViewById(R.id.item_storage);
                break;

            case R.id.item_restore:
                nextItem = (TextView) findViewById(R.id.item_benji);
                preItem = (TextView) findViewById(R.id.item_advanced_set);
                break;
            default:
                nextItem = null;
                preItem = null;
                break;
        }

        return (nextItem.isFocused() || preItem.isFocused());

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.item_right, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
