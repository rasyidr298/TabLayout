package com.rrdev.tablayout.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rrdev.tablayout.R;
import com.rrdev.tablayout.activity.DetailActivity;
import com.rrdev.tablayout.model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    private ArrayList<DataModel> mData;
    ItemListener mListener;

    public RecyclerViewAdapter(Context mContext, ArrayList<DataModel> mData, ItemListener mListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, final int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.img.setImageResource(mData.get(position).getImg());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);

                // pasing data to Detail Activity
                intent.putExtra("name",mData.get(position).getName());
                intent.putExtra("desc",mData.get(position).getDescripstion());
                intent.putExtra("img",mData.get(position).getImg());

                //startAct
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static  class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        private TextView tv_name;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.text_item);
            img = itemView.findViewById(R.id.img_item);
            cardView = itemView.findViewById(R.id.cvItem);
        }
    }

    public interface ItemListener{
        void onItemClick(DataModel pName, int position);
    }

    public void setFilter (ArrayList<DataModel> filterList){
        mData = new ArrayList<>();
        mData.addAll(filterList);
        notifyDataSetChanged();
    }

}
