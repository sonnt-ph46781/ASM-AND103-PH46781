package com.example.asm1;

public class carModel {
    private String id;
    private String ten;
    private int namSX;
    private String hang;
    private Double gia;

    public carModel(Double gia, String hang, int namSX, String ten, String id) {
        this.gia = gia;
        this.hang = hang;
        this.namSX = namSX;
        this.ten = ten;
        this.id = id;
    }


    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
