package com.example.cleaning;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter (Context context){
        this.context = context;
    }

    public int[] slide_images ={
            R.mipmap.ic_etc,
            R.mipmap.ic_point,
            R.mipmap.ic_money,
            R.mipmap.ic_guitar,
            R.mipmap.ic_disk
    };

    public String[] slide_headings = {
            "PESAN",
            "LOKASI",
            "BAYAR",
            "MENUNGGU",
            "SELESAI"
    };

    public String[] slide_descriptions ={
            "Pesan Aplikasi Sesuai dengan Kriteria\nMulai dari jenis tempat, ruangan hingga alat-alat\nyang akan digunakan",
            "Tentukkan lokasi dan jadwal yang\n diinginkan untuk memesan layanan cleaning",
            "Melakukan pembayaran yang sesuai",
            "Tim kami akan melakukan pengecekan lokasi sebelum\nmemulai pembersihan, apabila sudah sesuai akan langsung\ndikerjakan oleh tim kami.",
            "Selesai tugas tim kami, jangan lupa diberikan review dan komentar."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            layoutInflater = (LayoutInflater) context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate (R.layout.slide_layout, container, false);

            ImageView slideImageView = view.findViewById (R.id.imageView);
            TextView slideTextHeading = view.findViewById (R.id.titleOnBoard);
            TextView slideDescription = view.findViewById (R.id.descriptionOnBoard);

            slideImageView.setImageResource (slide_images[position]);
            slideTextHeading.setText (slide_headings[position]);
            slideDescription.setText (slide_descriptions[position]);

            container.addView (view);

            return view;
        }
        return true;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView ((RelativeLayout)object);
    }
}
