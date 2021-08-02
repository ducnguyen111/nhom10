package com.example.quanlychitieu.ui.Chi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.ui.adapter.ChiViewPageAapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChiFragment extends Fragment {
    private ViewPager2 viewPager2;
    private TabLayout layout;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2 = view.findViewById(R.id.viewPager2);
        layout = view.findViewById(R.id.tabLayout);
        ChiViewPageAapter chiViewPageAapter = new ChiViewPageAapter(getActivity());
        viewPager2.setAdapter(chiViewPageAapter);
        new TabLayoutMediator(layout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull @NotNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("Khoản Chi");
                } else {
                    tab.setText("Loại Chi");
                }
            }
        }).attach();


    }

    public ChiFragment() {
        // Required empty public constructor
    }

    public static ChiFragment newInstance(String param1, String param2) {
        ChiFragment fragment = new ChiFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chi, container, false);
    }
}