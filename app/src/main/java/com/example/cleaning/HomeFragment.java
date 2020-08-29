package com.example.cleaning;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator ();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate (R.layout.fragment_home,container,false);

        models = new ArrayList<> ();
        models.add (new Model (R.drawable.brochure,"One Day Jobs","Only one time jobs"));
        models.add (new Model (R.drawable.namecard,"Membership 12x","Routine cleaning at 1 per month for 12 month.\nGet free discount on sale"));

        adapter = new Adapter (models, getActivity ());

        viewPager = v.findViewById (R.id.viewPager);
        viewPager.setAdapter (adapter);
        viewPager.setPadding (130,0,130,0);

        colors = new Integer[]{
                getResources ().getColor (R.color.color1),
                getResources ().getColor (R.color.color2)
        };

        viewPager.addOnPageChangeListener (new ViewPager.OnPageChangeListener () {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position<adapter.getCount ()-1 && position <(colors.length -1)){
                    viewPager.setBackgroundColor (
                            (Integer) argbEvaluator.evaluate (
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]));
                }else{
                    viewPager.setBackgroundColor (colors[colors.length -1 ]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return v;
    }
}
