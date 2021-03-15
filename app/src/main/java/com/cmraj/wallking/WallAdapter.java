package com.cmraj.wallking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class WallAdapter extends RecyclerView.Adapter<WallViewHolder> {

    private Context context;
    private List <WallModel> wallModelList;

    public WallAdapter(Context context, List<WallModel> wallModelList) {
        this.context = context;
        this.wallModelList = wallModelList;
    }

    @NonNull
    @Override
    public WallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wall_item,parent,false);
        return new WallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallViewHolder holder, int position) {
        Glide.with(context).load(wallModelList.get(position).getMedium()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,FullScreenWall.class)
                .putExtra("large2x",wallModelList.get(position).getLarge2x()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return wallModelList.size();
    }
}

class WallViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    public WallViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.wallViewItem);
    }
}
