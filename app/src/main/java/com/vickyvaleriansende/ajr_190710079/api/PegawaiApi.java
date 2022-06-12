package com.vickyvaleriansende.ajr_190710079.api;

public class PegawaiApi {
    public static final String BASE_URL = "http://192.168.1.9:8000/api/";

    public static final String GET_ALL_URL = BASE_URL + "pegawai";
    public static final String GET_BY_ID_URL = BASE_URL + "pegawai/";
    public static final String ADD_URL = BASE_URL + "pegawai";
    public static final String UPDATE_URL = BASE_URL + "pegawai/";
    public static final String DELETE_URL = BASE_URL + "pegawai/";

    public static final String GET_ALL_PROMO_URL = BASE_URL + "promo";

    public static final String GET_PENYEWAAN_MOBIL_URL = BASE_URL + "laporanPenyewaanMobil/";
    public static final String GET_PENDAPATAN_TRANSAKSI_URL = BASE_URL + "laporanPendapatanTransaksi/";
    public static final String GET_TOP5_DRIVER_URL = BASE_URL + "laporanTop5Driver/";
    public static final String GET_TOP5_PELANGGAN_URL = BASE_URL + "laporanTop5Pelanggan/";
    public static final String GET_PERFORMA_DRIVER_URL = BASE_URL + "laporanPerformaDriver/";
}
