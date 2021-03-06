package com.example.dinr;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Home_Screen_Adapter extends RecyclerView.Adapter<Home_Screen_Adapter.myViewHolder> {

    Context mContext;
    List<item> mData;
    private OnItemListener mOnItemListener;

    public Home_Screen_Adapter(Context mContext, List<item> mData, OnItemListener onItemListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.mOnItemListener = onItemListener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.home_screen_card_layout, parent, false);
        return new myViewHolder(v, mOnItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int i) {
        holder.background.setImageResource(mData.get(i).getBackground());
        holder.title.setText(mData.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView background;
        TextView title;
        OnItemListener onItemListener;

        public myViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);
            background = itemView.findViewById(R.id.card_background);
            title = itemView.findViewById(R.id.titleTV);
            itemView.setOnClickListener(this);
            this.onItemListener = onItemListener;
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }
    public interface OnItemListener{
        void onItemClick(int position);
    }
}
