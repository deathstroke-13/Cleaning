package com.example.cleaning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_profile);
        getSupportActionBar ().hide ();
        CurvedBottomNavigationView curvedBottomNavigationView = findViewById(R.id.customBottomBar);
        curvedBottomNavigationView.inflateMenu(R.menu.bottom_nav_menu);
        setHomeItem(ProfileActivity.this);

        curvedBottomNavigationView.setOnNavigationItemSelectedListener (new BottomNavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId ()){
                    case R.id.action_home:
                        Intent intentHome = new Intent (ProfileActivity.this, MainActivity.class);
                        startActivity (intentHome);
                        break;

                    case R.id.action_profile:

                        break;
                }
                return false;
            }
        });
    }

    public static void setHomeItem(Activity activity) {
        CurvedBottomNavigationView curvedBottomNavigationView =
                activity.findViewById(R.id.customBottomBar);
        curvedBottomNavigationView.setSelectedItemId(R.id.action_profile);
    }
}