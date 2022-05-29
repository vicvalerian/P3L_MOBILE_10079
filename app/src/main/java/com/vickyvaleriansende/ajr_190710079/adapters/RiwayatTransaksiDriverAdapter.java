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
import com.vickyvaleriansende.ajr_190710079.models.RiwayatTransaksiDriverJson;

import java.util.ArrayList;
import java.util.List;

public class RiwayatTransaksiDriverAdapter extends RecyclerView.Adapter<RiwayatTransaksiDriverAdapter.ViewHolder> implements Filterable{
    private List<RiwayatTransaksiDriverJson> riwayatList, filteredRiwayatList;
    private Context context;
    public RiwayatTransaksiDriverAdapter(List<RiwayatTransaksiDriverJson> riwayatList, Context context) {
        this.riwayatList = riwayatList;
        filteredRiwayatList = new ArrayList<>(riwayatList);
        this.context = context;
    }

    @NonNull
    @Override
    public RiwayatTransaksiDriverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_item_riwayat_driver, parent, false);
        return new RiwayatTransaksiDriverAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RiwayatTransaksiDriverAdapter.ViewHolder holder, int position) {
        RiwayatTransaksiDriverJson riwayat = filteredRiwayatList.get(position);
        holder.tvid.setText(riwayat.getId_detail_transaksi());
        holder.tvnamacustomer.setText(riwayat.getNama_pelanggan());
        holder.tvnamamobil.setText(riwayat.getNama_mobil());
        holder.tvnamadriver.setText(riwayat.getNama_driver());
        holder.tvtanggalawal.setText(riwayat.getTgl_waktu_akhir_sewa());
        holder.tvtanggalselesai.setText(riwayat.getTgl_waktu_akhir_sewa());
        holder.tvrating.setText(String.valueOf(riwayat.getRating_driver_transaksi()));
    }

    @Override
    public int getItemCount() {
        return filteredRiwayatList.size();
    }

    public void setRiwayatList(List<RiwayatTransaksiDriverJson> riwayatList) {
        this.riwayatList = riwayatList;
        filteredRiwayatList = new ArrayList<>(riwayatList);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charSequenceString = charSequence.toString();
                List<RiwayatTransaksiDriverJson> filtered = new ArrayList<>();
                if (charSequenceString.isEmpty()) {
                    filtered.addAll(riwayatList);
                } else {
                    for (RiwayatTransaksiDriverJson riwayat : riwayatList) {
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
                filteredRiwayatList.addAll((List<RiwayatTransaksiDriverJson>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvid, tvnamacustomer, tvnamamobil, tvnamadriver, tvtanggalawal, tvtanggalselesai, tvrating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvid = itemView.findViewById(R.id.tv_idtransaksi);
            tvnamacustomer = itemView.findViewById(R.id.tv_namacustomer);
            tvnamamobil = itemView.findViewById(R.id.tv_namamobil);
            tvnamadriver = itemView.findViewById(R.id.tv_namadriver);
            tvtanggalawal = itemView.findViewById(R.id.tv_tanggalawaltransaksi);
            tvtanggalselesai = itemView.findViewById(R.id.tv_tanggalselesaitransaksi);
            tvrating = itemView.findViewById(R.id.tv_ratingdriver);
        }
    }
}
