package com.example.quanlychitieu.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.ui.dto.LoaiThu;
import com.example.quanlychitieu.ui.thu.LoaiThuFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LoaiThuAdapter extends ArrayAdapter<LoaiThu> {
    private Context context;
    public LoaiThuFragment fragment;
    private ArrayList<LoaiThu> loaiThus;
    TextView malt, tenlt;
    ImageView delete;


    public LoaiThuAdapter(@NonNull Context context, LoaiThuFragment loaiThuFragment, ArrayList<LoaiThu> loaiThus) {
        super(context, 0, loaiThus);
        this.fragment = loaiThuFragment;
        this.loaiThus = loaiThus;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_loaithu, null);
        }
        final LoaiThu loaiThu = loaiThus.get(position);
        if (loaiThu != null) {
            tenlt = view.findViewById(R.id.item_loaithu);
            malt = view.findViewById(R.id.item_maloaithu);
            delete = view.findViewById(R.id.delete_loaithu);
            malt.setText("ma"+loaiThu.maLoaiThu);
            tenlt.setText(""+loaiThu.tenLoaiThu);
        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               
            }
        });
        return view;
    }
}
