package com.example.quanlychitieu.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quanlychitieu.ui.Chi.KhoanChiFragment;
import com.example.quanlychitieu.ui.Chi.LoaiChiFragment;
import com.example.quanlychitieu.ui.thu.KhoanThuFragment;
import com.example.quanlychitieu.ui.thu.LoaiThuFragment;

import org.jetbrains.annotations.NotNull;

public class ChiViewPageAapter extends FragmentStateAdapter {


    public ChiViewPageAapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if(position==0){
            fragment=KhoanChiFragment.newInstance();
        }
        else {
            fragment= new LoaiChiFragment();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
