package com.example.quanlychitieu.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quanlychitieu.ui.thu.KhoanThuFragment;
import com.example.quanlychitieu.ui.thu.LoaiThuFragment;

import org.jetbrains.annotations.NotNull;

public class ThuViewPageAapter extends FragmentStateAdapter {
    public ThuViewPageAapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if (position==0){
            fragment= KhoanThuFragment.newInstance();
        }
        else {
            fragment= LoaiThuFragment.newInstance();
        }
        return fragment;
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}
