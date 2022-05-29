package com.vickyvaleriansende.ajr_190710079.api;

public class PelangganApi {
    public static final String BASE_URL = "http://192.168.1.10:8000/api/";

    public static final String GET_ALL_URL = BASE_URL + "pelanggan";
    public static final String GET_BY_ID_URL = BASE_URL + "pelanggan/";
    public static final String ADD_URL = BASE_URL + "pelanggan";
    public static final String UPDATE_URL = BASE_URL + "pelanggan/";
    public static final String DELETE_URL = BASE_URL + "pelanggan/";

    public static final String GET_ALL_PROMO_URL = BASE_URL + "promo";
    public static final String GET_ALL_MOBIL_URL = BASE_URL + "mobil";
    public static final String GET_ALL_DETAIL_TRANSAKSI_PELANGGAN_URL = BASE_URL + "detailTransaksiPelangganMobile/";
}
