package com.example.olya.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CartoonViewHolder> {

    private List<Cartoon> cartoons;

    public static class CartoonViewHolder extends RecyclerView.ViewHolder {
        private TextView cartoonName;
        private ImageView cartoonImage;

        public CartoonViewHolder(View itemView) {
            super(itemView);
            cartoonName = (TextView) itemView.findViewById(R.id.cartoon_name);
            cartoonImage = (ImageView) itemView.findViewById(R.id.cartoon_image);
        }

        public void bindCartoon(Cartoon cartoon) {
            Picasso.with(cartoonImage.getContext()).load(cartoon.getImageId()).resize(1280, 720).centerCrop().into(cartoonImage);
            cartoonName.setText(cartoon.getName());
        }
    }

    public RecyclerAdapter(List<Cartoon> cartoons) {
        this.cartoons = cartoons;
    }

    @Override
    public int getItemCount() {
        return cartoons.size();
    }

    @Override
    public RecyclerAdapter.CartoonViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,
                parent, false);
        return new CartoonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.CartoonViewHolder holder, int position) {
        Cartoon itemCartoon = cartoons.get(position);
        holder.bindCartoon(itemCartoon);
    }

}