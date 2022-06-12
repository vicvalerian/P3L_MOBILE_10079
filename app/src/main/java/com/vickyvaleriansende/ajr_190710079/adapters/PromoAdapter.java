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
import com.vickyvaleriansende.ajr_190710079.models.PromoJson;

import java.util.ArrayList;
import java.util.List;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.ViewHolder> implements Filterable{
    private List<PromoJson> promoList, filteredPromoList;
    private Context context;

    public PromoAdapter(List<PromoJson> promoList, Context context) {
        this.promoList = promoList;
        filteredPromoList = new ArrayList<>(promoList);
        this.context = context;
    }

    @NonNull
    @Override
    public PromoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_item_promo, parent, false);
        return new PromoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PromoJson promo = filteredPromoList.get(position);
        holder.tvKodePromo.setText(promo.getKode_promo() + " - ");
        holder.tvJumlahPromo.setText(String.valueOf(promo.getDiskon_promo()) + "%");
        holder.tvJenisPromo.setText(promo.getJenis_promo());
        holder.tvKeterangan.setText(promo.getKeterangan_promo());
        holder.tvStatus.setText(promo.getStatus_promo());
    }

    @Override
    public int getItemCount() {
        return filteredPromoList.size();
    }

    public void setPromoList(List<PromoJson> mahasiswaList) {
        this.promoList = mahasiswaList;
        filteredPromoList = new ArrayList<>(mahasiswaList);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charSequenceString = charSequence.toString();
                List<PromoJson> filtered = new ArrayList<>();
                if (charSequenceString.isEmpty()) {
                    filtered.addAll(promoList);
                } else {
                    for (PromoJson promo : promoList) {
                        if (promo.getKode_promo().toLowerCase().contains(charSequenceString.toLowerCase()))
                            filtered.add(promo);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filtered;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults
                    filterResults) {
                filteredPromoList.clear();
                filteredPromoList.addAll((List<PromoJson>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJenisPromo, tvKodePromo, tvStatus, tvKeterangan, tvJumlahPromo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKodePromo = itemView.findViewById(R.id.tv_kode_promo);
            tvJenisPromo = itemView.findViewById(R.id.tv_jenis_promo);
            tvJumlahPromo = itemView.findViewById(R.id.tv_jml_promo);
            tvStatus = itemView.findViewById(R.id.tv_status_promo);
            tvKeterangan = itemView.findViewById(R.id.tv_keterangan_promo);
        }
    }
}
