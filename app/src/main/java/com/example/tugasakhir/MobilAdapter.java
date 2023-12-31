package com.example.tugasakhir;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MobilAdapter extends RecyclerView.Adapter<MobilAdapter.MobilViewHolder> {

    private List<Mobil> mobilList;

    public MobilAdapter(List<Mobil> mobilList) {
        this.mobilList = mobilList;
    }
    private static ClickListener clickListener;

    @NonNull
    @Override
    public MobilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mobil, parent, false);
        return new MobilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MobilViewHolder holder, int position) {
        Mobil mobil = mobilList.get(position);
        holder.tvNamaMobil.setText(mobil.getNamaMobil());
        holder.tvTipeMobil.setText(mobil.getTipeMobil());
        holder.btMobil.setText(mobil.getHargaSewa());
    }

    @Override
    public int getItemCount() {
        return mobilList.size();
    }

    static class MobilViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvNamaMobil, tvTipeMobil;
        Button btMobil;

        MobilViewHolder(View itemView) {
            super(itemView);
            tvNamaMobil = itemView.findViewById(R.id.tvNamaMobil);
            tvTipeMobil = itemView.findViewById(R.id.textView4);
            btMobil = itemView.findViewById(R.id.btMobil);
        }


        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), itemView);
        }
    }

    public void setOnItemClickListener(MobilAdapter.ClickListener clickListener) {
        MobilAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

}
