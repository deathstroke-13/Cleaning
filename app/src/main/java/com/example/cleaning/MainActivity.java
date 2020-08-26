package com.example.cleaning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {



    FloatingActionButton fab;
    Snackbar mSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        Objects.requireNonNull (getSupportActionBar ()).hide ();
        CurvedBottomNavigationView curvedBottomNavigationView = findViewById(R.id.customBottomBar);
        curvedBottomNavigationView.setOnNavigationItemSelectedListener (navListener);
        getSupportFragmentManager ().beginTransaction ().replace (R.id.fragment_container,new HomeFragment ()).commit ();
        //setHomeItem(MainActivity.this);

        final ScrollView layout = findViewById(R.id.layout_scroll);
        mSnackbar = Snackbar.make(layout, "Tekan sekali lagi untuk keluar", Snackbar.LENGTH_SHORT);

        fab = findViewById (R.id.fab_order);
        fab.setOnClickListener (view -> {
            Intent onBoard = new Intent (MainActivity.this, OnBoardActivity.class);
            startActivity (onBoard);
        });

    }

    private CurvedBottomNavigationView.OnNavigationItemSelectedListener navListener =
            menuItem -> {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId ()){
                    case R.id.action_profile:
                        selectedFragment = new ProfileFragment ();
                        break;

                    case R.id.action_home:
                        selectedFragment = new HomeFragment();
                        break;
                }

                assert selectedFragment != null;
                getSupportFragmentManager ().beginTransaction ().replace (R.id.fragment_container,selectedFragment).commit ();

                return true;
            };

    public void onBackPressed() {
        //CurvedBottomNavigationView curvedBottomNavigationView =  findViewById(R.id.customBottomBar);
        //int seletedItemId = curvedBottomNavigationView.getSelectedItemId();
        if(mSnackbar.isShown ()){
            super.onBackPressed ();
        }else {
            mSnackbar.show ();
        }
    }


}
