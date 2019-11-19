package com.androboot.heyhungryinternship3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class imageAdaptor extends RecyclerView.Adapter<imageAdaptor.imageViewHolder> {

    private Context mContext;
    private List<upload> muploads;

    public imageAdaptor(Context context, List<upload> uploads){
        mContext=context;
        muploads=uploads;
    }

    @NonNull
    @Override
    public imageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_items, parent, false);
        return new imageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull imageViewHolder holder, int position) {
        upload uploadCurrent = muploads.get(position);
        holder.textViewName.setText(uploadCurrent.getmName());
        Picasso.get().load(uploadCurrent.getmUrl())
        .fit()
                .placeholder(R.mipmap.ic_launcher)
        .centerCrop()
        .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return muploads.size();
    }

    public class imageViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName;
        public ImageView imageView;
        public imageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName= itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
        }
    }
}
