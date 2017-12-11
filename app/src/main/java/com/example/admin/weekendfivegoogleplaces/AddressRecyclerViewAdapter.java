package com.example.admin.weekendfivegoogleplaces;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.weekendfivegoogleplaces.mapdata.Result;

import java.util.List;

/**
 * Created by  Admin on 12/10/2017.
 */

public class AddressRecyclerViewAdapter extends RecyclerView.Adapter<AddressRecyclerViewAdapter.ViewHolder> {
    List<Result> resultList;

    public AddressRecyclerViewAdapter(List<Result> resultList) {
        this.resultList = resultList;
    }

    @Override
    public AddressRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_address_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AddressRecyclerViewAdapter.ViewHolder holder, int position) {
        String address = resultList.get(position).getFormattedAddress();
        holder.tvAddress.setText(address);

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            tvAddress = itemView.findViewById(R.id.tvAddressrc);
        }
    }
}
