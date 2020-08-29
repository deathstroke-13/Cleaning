package com.example.cleaning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {

    public static int SPLASH_SCREEN=3000;
    Animation topAnim, botAnim;
    @BindView (R.id.logo_splash) ImageView imageView;
    @BindView (R.id.brand_splash) TextView brandSplash;
    @BindView (R.id.slogan) TextView slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_splash_screen);
        getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull (getSupportActionBar ()).hide ();
        ButterKnife.bind (this);

        topAnim = AnimationUtils.loadAnimation (this,R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation (this,R.anim.bottom_animation);

        imageView.setAnimation (topAnim);
        brandSplash.setAnimation (botAnim);
        slogan.setAnimation (botAnim);

        new Handler ().postDelayed (() -> {
            Intent intent = new Intent (SplashScreen.this, LoginActivity.class);
            Pair[] pairs = new Pair[3];
            pairs[0] = new Pair <View, String>(imageView,"trans_image");
            pairs[1] = new Pair <View, String>(brandSplash,"trans_brand");
            pairs[2] = new Pair <View, String>(slogan,"trans_slogan");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation (SplashScreen.this,pairs);
            startActivity (intent,options.toBundle ());
            finish ();
        },SPLASH_SCREEN);
    }
}