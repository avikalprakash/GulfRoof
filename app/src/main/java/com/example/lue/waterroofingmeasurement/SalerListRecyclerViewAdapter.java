package com.example.lue.waterroofingmeasurement;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lue.waterroofingmeasurement.SalerListFragment.OnListFragmentInteractionListener;


import java.util.List;

import Adapter.SellerItemDetails;


public class SalerListRecyclerViewAdapter extends RecyclerView.Adapter<SalerListRecyclerViewAdapter.ViewHolder> {

    private final List<SellerItemDetails> mValues;
    private final OnListFragmentInteractionListener mListener;

    public SalerListRecyclerViewAdapter(List<SellerItemDetails> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_saller, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mUsername.setText(mValues.get(position).getUser_name());
        holder.mMobile.setText(mValues.get(position).getMobile());
        holder.mEmail.setText(mValues.get(position).getEmail());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mUsername;
        public final TextView mMobile;
        public final TextView mEmail;
        public SellerItemDetails mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mUsername = (TextView) view.findViewById(R.id.username);
            mMobile = (TextView) view.findViewById(R.id.mobile);
            mEmail = (TextView) view.findViewById(R.id.email);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mUsername.getText() + "'";
        }
    }
}
