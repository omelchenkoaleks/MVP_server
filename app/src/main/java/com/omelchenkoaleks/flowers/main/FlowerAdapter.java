package com.omelchenkoaleks.flowers.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.omelchenkoaleks.flowers.R;
import com.omelchenkoaleks.flowers.model.Flower;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;


public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerHolder>{

    private Context context;
    private List<Flower> flowers;

    public FlowerAdapter(Context context, List<Flower> flowers){
        this.flowers = flowers;
        this.context = context;
    }

    public void setFlowers(List<Flower> flowers){
        this.flowers = flowers;
        notifyDataSetChanged();
    }

    @Override
    public FlowerHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flower_item, parent, false);
        return new FlowerHolder(view);
    }

    @Override
    public void onBindViewHolder(FlowerHolder holder, int position){
        Flower item = flowers.get(position);
        holder.flower = item;

        holder.flowerRus.setText(item.getFlower_rus());
        holder.flowerLat.setText(item.getFlower_lat());
        holder.flowerDesc.setText(item.getFlower_desc());

        Picasso.with(context)
                .load(item.getFlower_img())
                .error(R.drawable.ic_flower)
                .placeholder(R.drawable.ic_flower)
                .fit()
                .into(holder.flowerImg);
    }

    @Override
    public int getItemCount(){
        if (flowers == null){
            return 0;
        }else{
            return flowers.size();
        }
    }

    static class FlowerHolder extends RecyclerView.ViewHolder{

        Flower flower;
        ImageView flowerImg;
        TextView flowerRus, flowerLat, flowerDesc;

        FlowerHolder(View itemView) {
            super(itemView);

            flowerImg = (ImageView) itemView.findViewById(R.id.flower_img);
            flowerRus = (TextView) itemView.findViewById(R.id.flower_rus);
            flowerLat = (TextView) itemView.findViewById(R.id.flower_lat);
            flowerDesc = (TextView) itemView.findViewById(R.id.flower_desc);
        }
    }
}