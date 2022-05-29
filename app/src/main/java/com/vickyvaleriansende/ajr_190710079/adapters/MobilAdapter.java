package com.vickyvaleriansende.ajr_190710079.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vickyvaleriansende.ajr_190710079.R;
import com.vickyvaleriansende.ajr_190710079.models.MobilJson;

import java.util.ArrayList;
import java.util.List;

public class MobilAdapter extends RecyclerView.Adapter<MobilAdapter.ViewHolder> implements Filterable {
    private List<MobilJson> mobilList, filteredMobilList;
    private Context context;

    public MobilAdapter(List<MobilJson> mobilList, Context context){
        this.mobilList = mobilList;
        filteredMobilList = new ArrayList<>(mobilList);
        this.context = context;
    }

    @NonNull
    @Override
    public MobilAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_item_mobil, parent, false);
        return new MobilAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MobilAdapter.ViewHolder holder, int position) {
        MobilJson mobil = filteredMobilList.get(position);
        holder.tvNamaMobil.setText(mobil.getNama_mobil());
        holder.tvJenisTransimisi.setText(mobil.getJenis_transmisi());
        holder.tvJenisBahanBakar.setText(mobil.getJenis_bahan_bakar());
        holder.tvVolumeBahanBakar.setText(mobil.getVolume_bahan_bakar());
        holder.tvWarnaMobil.setText(mobil.getWarna_mobil());
        holder.tvKapasitasPenumpang.setText(mobil.getKapasitas_penumpang());
        holder.tvFasilitasMobil.setText(mobil.getFasilitas_mobil());
        holder.tvHargaSewa.setText("Rp."+String.valueOf(mobil.getSewa_harian_mobil()));
        Glide.with(context)
                .load("http://192.168.1.10:8000/storage/"+mobil.getFoto_mobil())
                .placeholder(R.drawable.logoajr)
                .into(holder.imgMobilShow);
        holder.tvNomorPlat.setText(mobil.getPlat_mobil());
        holder.tvNamaTipeMobil.setText(mobil.getTipe_mobil());
    }

    @Override
    public int getItemCount() {
        return filteredMobilList.size();
    }

    public void setMobilList(List<MobilJson> mobilList) {
        this.mobilList = mobilList;
        filteredMobilList = new ArrayList<>(mobilList);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charSequenceString = charSequence.toString();
                List<MobilJson> filtered = new ArrayList<>();
                if (charSequenceString.isEmpty()) {
                    filtered.addAll(mobilList);
                } else {
                    for (MobilJson mobil : mobilList) {
                        if (mobil.getNama_mobil().toLowerCase().contains(charSequenceString.toLowerCase()))
                            filtered.add(mobil);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filtered;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults
                    filterResults) {
                filteredMobilList.clear();
                filteredMobilList.addAll((List<MobilJson>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaMobil, tvJenisTransimisi, tvJenisBahanBakar, tvVolumeBahanBakar, tvWarnaMobil,
                tvKapasitasPenumpang, tvFasilitasMobil, tvHargaSewa, tvNomorPlat, tvNamaTipeMobil;
        ImageView imgMobilShow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaMobil = itemView.findViewById(R.id.tv_namamobil);
            tvJenisTransimisi = itemView.findViewById(R.id.tv_jenistransmisi);
            tvJenisBahanBakar = itemView.findViewById(R.id.tv_jenisbahanbakar);
            tvVolumeBahanBakar = itemView.findViewById(R.id.tv_volumebahanbakar);
            tvWarnaMobil = itemView.findViewById(R.id.tv_warnamobil);
            tvKapasitasPenumpang = itemView.findViewById(R.id.tv_kapasitaspenumpang);
            tvFasilitasMobil = itemView.findViewById(R.id.tv_fasilitasmobil);
            tvHargaSewa = itemView.findViewById(R.id.tv_hargasewa);
            tvNomorPlat = itemView.findViewById(R.id.tv_nomorplat);
            tvNamaTipeMobil = itemView.findViewById(R.id.tv_namatipemobil);
            imgMobilShow = itemView.findViewById(R.id.ImgMobil);
        }
    }
}
