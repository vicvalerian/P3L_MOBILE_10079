package com.vickyvaleriansende.ajr_190710079.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vickyvaleriansende.ajr_190710079.R;
import com.vickyvaleriansende.ajr_190710079.models.RiwayatTransaksiPelangganJson;

import java.util.ArrayList;
import java.util.List;

public class RiwayatTransaksiPelangganAdapter extends RecyclerView.Adapter<RiwayatTransaksiPelangganAdapter.ViewHolder> implements Filterable{
    private List<RiwayatTransaksiPelangganJson> riwayatList, filteredRiwayatList;
    private Context context;
    public RiwayatTransaksiPelangganAdapter(List<RiwayatTransaksiPelangganJson> riwayatList, Context context) {
        this.riwayatList = riwayatList;
        filteredRiwayatList = new ArrayList<>(riwayatList);
        this.context = context;
    }

    @NonNull
    @Override
    public RiwayatTransaksiPelangganAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_item_riwayat_pelanggan, parent, false);
        return new RiwayatTransaksiPelangganAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RiwayatTransaksiPelangganAdapter.ViewHolder holder, int position) {
        RiwayatTransaksiPelangganJson riwayat = filteredRiwayatList.get(position);
        holder.tvid.setText(riwayat.getId_transaksi());
        holder.tviddetail.setText(riwayat.getId_detail_transaksi());
        holder.tvnamacustomer.setText(riwayat.getNama_pelanggan());
        holder.tvjenispeminjaman.setText(riwayat.getJenis_transaksi() + " - " + riwayat.getMetode_pembayaran());
        holder.tvnamamobil.setText(riwayat.getPlat_mobil() + " - " + riwayat.getNama_mobil());
        holder.tvnamadriver.setText(riwayat.getNama_driver());
        holder.tvnamapegawai.setText(riwayat.getNama_pegawai());
        holder.tvtanggalawal.setText(riwayat.getTgl_waktu_akhir_sewa());
        holder.tvtanggalselesai.setText(riwayat.getTgl_waktu_akhir_sewa());
        holder.tvtanggalpengembalian.setText(riwayat.getTgl_pengembalian());
        holder.tvtotaldenda.setText(String.valueOf("Rp." + riwayat.getDenda_transaksi()));
        holder.tvtotalpembayaran.setText(String.valueOf("Rp." + riwayat.getJumlah_pembayaran()));
        holder.tvtotaldiskon.setText("Rp." + String.valueOf(riwayat.getDiskon_transaksi()));
    }

    @Override
    public int getItemCount() {
        return filteredRiwayatList.size();
    }

    public void setRiwayatList(List<RiwayatTransaksiPelangganJson> riwayatList) {
        this.riwayatList = riwayatList;
        filteredRiwayatList = new ArrayList<>(riwayatList);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charSequenceString = charSequence.toString();
                List<RiwayatTransaksiPelangganJson> filtered = new ArrayList<>();
                if (charSequenceString.isEmpty()) {
                    filtered.addAll(riwayatList);
                } else {
                    for (RiwayatTransaksiPelangganJson riwayat : riwayatList) {
                        if (riwayat.getId_detail_transaksi().toLowerCase().contains(charSequenceString.toLowerCase()))
                            filtered.add(riwayat);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filtered;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults
                    filterResults) {
                filteredRiwayatList.clear();
                filteredRiwayatList.addAll((List<RiwayatTransaksiPelangganJson>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvid, tvnamacustomer, tvjenispeminjaman, tvnamamobil, tvnamadriver, tvnamapegawai, tviddetail,
                tvtanggalawal, tvtanggalselesai, tvtanggalpengembalian, tvtotaldenda, tvtotaldiskon, tvtotalpembayaran;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvid = itemView.findViewById(R.id.tv_idtransaksi);
            tvnamacustomer = itemView.findViewById(R.id.tv_namacustomer);
            tvjenispeminjaman = itemView.findViewById(R.id.tv_jenispeminjaman);
            tvnamamobil = itemView.findViewById(R.id.tv_namamobil);
            tvnamadriver = itemView.findViewById(R.id.tv_namadriver);
            tvnamapegawai = itemView.findViewById(R.id.tv_namapegawai);
            tvtanggalawal = itemView.findViewById(R.id.tv_tanggalawaltransaksi);
            tvtanggalselesai = itemView.findViewById(R.id.tv_tanggalselesaitransaksi);
            tvtanggalpengembalian = itemView.findViewById(R.id.tv_tanggalpengembaliantransaksi);
            tvtotaldenda = itemView.findViewById(R.id.tv_totaldenda);
            tvtotalpembayaran = itemView.findViewById(R.id.tv_totalpembayaran);
            tvtotaldiskon = itemView.findViewById(R.id.tv_totaldiskon);
            tviddetail = itemView.findViewById(R.id.tv_iddetailtransaksi);
        }
    }
}
