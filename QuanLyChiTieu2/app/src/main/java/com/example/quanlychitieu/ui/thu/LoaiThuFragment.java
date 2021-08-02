package com.example.quanlychitieu.ui.thu;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Context;
import android.content.LocusId;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.dao.LoaiThuDao;
import com.example.quanlychitieu.ui.adapter.LoaiThuAdapter;
import com.example.quanlychitieu.ui.dto.LoaiThu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LoaiThuFragment extends Fragment {
    private ListView listView;

    private LoaiThuAdapter adapter;
    Dialog dialog;
    LoaiThuDao dao;
    FloatingActionButton fab;
    ArrayList<LoaiThu> list;
    EditText tenloaithu1;
    EditText maloaithu1;
    Button add, cancle1;
    LoaiThu loaiThu;


    public static LoaiThuFragment newInstance() {
        return new LoaiThuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.loai_thu_fragment, container, false);
        listView = v.findViewById(R.id.recyclerView_loaithu);
        fab = v.findViewById(R.id.floating_loaithu);
        dao = new LoaiThuDao(getActivity());
        updates();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(getActivity(), 0);
            }
        });


        return v;
    }

    protected void showDialog(final Context context, final int i) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_loaithu);
        tenloaithu1 = dialog.findViewById(R.id.ed_loaithu);
        maloaithu1 = dialog.findViewById(R.id.ed_maloaithu);
        add = dialog.findViewById(R.id.btn_loaithu);
        cancle1 = dialog.findViewById(R.id.btn_cancle);
        if (i != 0) {
            maloaithu1.setText(String.valueOf(loaiThu.maLoaiThu));
            tenloaithu1.setText(loaiThu.tenLoaiThu);
        }
        cancle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaiThu = new LoaiThu();
                loaiThu.setMaLoaiThu(Integer.parseInt(maloaithu1.getText().toString()));
                loaiThu.setTenLoaiThu(tenloaithu1.getText().toString());
                if (check() > 0) {
                    if (i == 0) {
                        if (dao.insert(loaiThu) > 0) {
                            Toast.makeText(context, "add thanh cong", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "add that bai", Toast.LENGTH_SHORT).show();
                        }
                    }
                    // vkl sao giống bài ass thiết kế giao diện thế
                    else {

                    }
                }

                updates();
                dialog.dismiss();
            }

        });
        dialog.show();
    }

    private int check() {
        int c = 1;
        if (tenloaithu1.getText().length() == 0) {
            Toast.makeText(getContext(), "khong duoc de trong", Toast.LENGTH_SHORT).show();
            return c = -1;
        }
        return c;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void updates() {
        list = (ArrayList<LoaiThu>) dao.getAll();
        adapter = new LoaiThuAdapter(getActivity(), this, list);
        listView.setAdapter(adapter);
    }

}