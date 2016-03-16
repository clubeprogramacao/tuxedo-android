package com.fcouceiro.tuxedo;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by franciscocouceiro on 16/03/16.
 */
public class SuitsAdapter extends RecyclerView.Adapter<SuitsAdapter.ViewHolder> {

    private List<SuitSchema> mDataSet;
    private Context mInContext;

    public SuitsAdapter(Context context, List<SuitSchema> suits){
        this.mDataSet = suits;
        this.mInContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.suit_view, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SuitSchema suit = mDataSet.get(position);

        holder.mTextView.setText(suit.getSuitName());

        if(suit.hasImageUrl()){
            Picasso.with(mInContext)
                    .load(Uri.parse(suit.getImageUrl()))
                    .placeholder(R.drawable.placeholder)
                    .fit()
                    .centerCrop()
                    .into(holder.mImageView);
        }
        else {
            holder.mImageView.setImageResource(suit.getImageDrawableId());
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.txtSuitName);
            mImageView = (ImageView) v.findViewById(R.id.imgSuit);
        }
    }
}
