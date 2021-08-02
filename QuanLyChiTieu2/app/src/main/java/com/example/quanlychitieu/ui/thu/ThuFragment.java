package com.example.quanlychitieu.ui.thu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.ui.adapter.ThuViewPageAapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;
public class ThuFragment extends Fragment {
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    public ThuFragment() {

    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2 = view.findViewById(R.id.viewPager22);
        tabLayout = view.findViewById(R.id.tabLayout2);
        ThuViewPageAapter thuViewPageAapter = new ThuViewPageAapter(getActivity());
        viewPager2.setAdapter(thuViewPageAapter);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull @NotNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("Khoản Thu");
                } else {
                    tab.setText("Loại thu");
                }
            }
        }).attach();
    }
    public static ThuFragment newInstance(String param1, String param2) {
        ThuFragment fragment = new ThuFragment();
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
        return inflater.inflate(R.layout.fragment_thu, container, false);
    }
}