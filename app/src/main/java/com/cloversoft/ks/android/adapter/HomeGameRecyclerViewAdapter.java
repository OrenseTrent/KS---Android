package com.cloversoft.ks.android.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cloversoft.ks.R;
import com.cloversoft.ks.data.model.api.SampleModel;
import com.cloversoft.ks.vendor.android.base.BaseRecylerViewAdapter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;


public class HomeGameRecyclerViewAdapter extends BaseRecylerViewAdapter<HomeGameRecyclerViewAdapter.ViewHolder, SampleModel>{

    private ClickListener clickListener;

    public HomeGameRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getDefaultView(parent, R.layout.adapter_home_gamer));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(getItem(position));

//        holder.nameTXT.setText("Position " + holder.getItem().id);
        holder.imageView.setImageResource(holder.getItem().image);
//        Glide.with(getContext()).load(R.drawable.cas1).centerCrop().into(holder.imageView);

    }

    public class ViewHolder extends BaseRecylerViewAdapter.ViewHolder{

        @BindView(R.id.imageView)       ImageView imageView;

        public ViewHolder(View view) {
            super(view);
        }

        public SampleModel getItem() {
            return (SampleModel) super.getItem();
        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick(SampleModel sampleModel);
    }
} 
