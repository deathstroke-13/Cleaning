package com.example.cleaning;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnBoardActivity extends AppCompatActivity {

    private TextView[] mDots;

    @BindView (R.id.layoutDots) LinearLayout layoutDots;
    @BindView (R.id.viewPagerOnBoard) ViewPager vPagerOnBoard;
    @BindView (R.id.buttonFinish) Button finishButton;
    @BindView (R.id.buttonNext) Button nextButton;
    @BindView (R.id.buttonPrev) Button prevButton;

    public int currrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_on_board);
        ButterKnife.bind (this);
        //Toolbar toolbar = findViewById (R.id.toolbar);

        SliderAdapter sliderAdapter = new SliderAdapter (this);

        vPagerOnBoard.setAdapter (sliderAdapter);
        addDotsIndicator(0);
        vPagerOnBoard.addOnPageChangeListener (viewListener);

        nextButton.setOnClickListener (view -> vPagerOnBoard.setCurrentItem (currrentPage + 1));

        prevButton.setOnClickListener (view -> vPagerOnBoard.setCurrentItem (currrentPage - 1));
    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[5];
        layoutDots.removeAllViews ();
        for(int i = 0 ; i < mDots.length ; i++){
            mDots[i] = new TextView (this);
            mDots[i].setText (Html.fromHtml ("&#8226"));
            mDots[i].setTextSize (35);
            mDots[i].setTextColor (getResources ().getColor (R.color.tranparentWhite));

            layoutDots.addView (mDots[i]);
        }
        if(mDots.length > 0){
            mDots[position].setTextColor (getResources ().getColor (R.color.White));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener () {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onPageSelected(int position) {
            addDotsIndicator (position);
            currrentPage = position;
            if(position == 0){
                nextButton.setEnabled (true);
                prevButton.setEnabled (false);
                prevButton.setVisibility (View.INVISIBLE);
                finishButton.setVisibility (View.GONE);
                nextButton.setVisibility (View.VISIBLE);

                nextButton.setText ("Next");
                prevButton.setText ("");
            }else if(position == mDots.length -1){
                nextButton.setEnabled (true);
                prevButton.setEnabled (true);
                prevButton.setVisibility (View.VISIBLE);
                finishButton.setVisibility (View.VISIBLE);
                nextButton.setVisibility (View.GONE);

                //nextButton.setText ("Finish");
                prevButton.setText ("Back");
            }else{
                nextButton.setEnabled (true);
                prevButton.setEnabled (true);
                prevButton.setVisibility (View.VISIBLE);
                finishButton.setVisibility (View.GONE);
                nextButton.setVisibility (View.VISIBLE);

                nextButton.setText ("Next");
                prevButton.setText ("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}