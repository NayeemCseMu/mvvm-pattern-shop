package com.example.mvvm_pattern_shop.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvm_pattern_shop.R;
import com.example.mvvm_pattern_shop.Service.Model.Product;
import com.example.mvvm_pattern_shop.Service.Model.ProductModel;

import java.util.List;

public class HomeProductAdapter extends  RecyclerView.Adapter<HomeProductAdapter.MyViewHolder> {

    private Context context;
    private List<Product> mList;

    public HomeProductAdapter(Context context, List<Product> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view =  LayoutInflater.from(context).inflate(R.layout.item_card_layout,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mDescription.setText(mList.get(position).getDescription());
        holder.mTitle.setText(mList.get(position).getName());
        holder.mPrice.setText(mList.get(position).getPrice());
//        Glide.with(context).load(mList.get(position).getImagePublicId()).into(holder.imageView);
        Glide.with(context).load("https://images.unsplash.com/photo-1612817288484-6f916006741a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YmVhdXR5JTIwcHJvZHVjdHN8ZW58MHx8MHx8&w=1000&q=80").into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        if(this.mList!=null){
            return mList.size();
        }
       else{
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView mTitle, mDescription, mPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tvTitle);
            mDescription = itemView.findViewById(R.id.tvDescription);
            mPrice = itemView.findViewById(R.id.tvPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
