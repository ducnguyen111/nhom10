package com.example.chitieucanhan.Dto;

public class ThongKe {
    private String khoanthukhoanchi;
    private String sotien;

    public String getKhoanthukhoanchi() {
        return khoanthukhoanchi;
    }

    public void setKhoanthukhoanchi(String khoanthukhoanchi) {
        this.khoanthukhoanchi = khoanthukhoanchi;
    }

    public String getSotien() {
        return sotien;
    }

    public void setSotien(String sotien) {
        this.sotien = sotien;
    }

    public ThongKe(String khoanthukhoanchi, String sotien) {
        this.khoanthukhoanchi = khoanthukhoanchi;
        this.sotien = sotien;
    }

    public ThongKe() {
    }
}
