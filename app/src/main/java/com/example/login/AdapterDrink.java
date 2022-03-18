package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterDrink extends RecyclerView.Adapter<AdapterDrink.ViewHolder> {

        private List<Drink> mData;
        private LayoutInflater mInflater;
        private Context context;

        private final AdapterDrink.ItemClickListener mClickListener = new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               Drink drink = mData.get(position);
                Intent i = new Intent(context, DetailsDrinkAc.class);
                i.putExtra("drink", (Parcelable) drink);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

            }
        };

    // data is passed into the constructor
        AdapterDrink(Context context, List<Drink> data) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
          this.context= context;
        }

        // inflates the row layout from xml when needed
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.row, parent, false);
            return new AdapterDrink.ViewHolder(view);
        }

    // binds the data to the TextView in each row
        @Override
        public void onBindViewHolder(AdapterDrink.ViewHolder holder, int position) {
          Drink drink = mData.get(position);
            holder.tvName.setText(drink.getName());
            //holder.ivPhoto.setImageDrawable(rest.getPhoto());
        }

        // total number of rows
        @Override
        public int getItemCount() {
            return mData.size();
        }


        // stores and recycles views as they are scrolled off screen
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView tvName;
            TextView tvprice;
            ImageView ivPhoto;

            ViewHolder(View itemView) {
                super(itemView);
                tvName = itemView.findViewById(R.id.namerow);
                tvprice = itemView.findViewById(R.id.pricerow);
                ivPhoto = itemView.findViewById(R.id.Imdrink);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            }
        }

        // convenience method for getting data at click position
       Drink DrinkgetItem(int id) {
            return mData.get(id);
        }


        // parent activity will implement this method to respond to click events
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }

