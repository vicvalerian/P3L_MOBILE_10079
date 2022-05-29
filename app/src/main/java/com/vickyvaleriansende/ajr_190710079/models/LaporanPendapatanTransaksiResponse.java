package com.vickyvaleriansende.ajr_190710079.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanPendapatanTransaksiResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<LaporanPendapatanTransaksiJson> laporanPendapatanTransaksiJsonList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LaporanPendapatanTransaksiJson> getLaporanPendapatanTransaksiJsonList() {
        return laporanPendapatanTransaksiJsonList;
    }

    public void setLaporanPendapatanTransaksiJsonList(List<LaporanPendapatanTransaksiJson> laporanPendapatanTransaksiJsonList) {
        this.laporanPendapatanTransaksiJsonList = laporanPendapatanTransaksiJsonList;
    }
}
