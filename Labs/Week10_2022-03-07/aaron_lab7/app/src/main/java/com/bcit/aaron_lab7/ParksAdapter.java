package com.bcit.aaron_lab7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ParksAdapter extends RecyclerView.Adapter<ParksAdapter.ViewHolder> {

    private List<OffLeashParks.Record> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * This template comes with a TextView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView parkName;
        private final TextView location;
        private final TextView address;

        public ViewHolder(View view) {
            super(view);

            parkName = view.findViewById(R.id.textView_parks_parkName); //error here should be expected, this is a template
            location = view.findViewById(R.id.textView_parks_location); //error here should be expected, this is a template
            address = view.findViewById(R.id.textView_parks_address); //error here should be expected, this is a template
        }

        public TextView getParkName() {
            return parkName;
        }

        public TextView getLocation() {
            return location;
        }

        public TextView getAddress() {
            return address;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public ParksAdapter(List<OffLeashParks.Record> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_parks, viewGroup, false); //error here should be expected, this is a template

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        if (localDataSet.get(position).fields.name != null) {
        }
        viewHolder.getParkName().setText(localDataSet.get(position).fields.name);
        viewHolder.getLocation().setText(localDataSet.get(position).fields.geo_local_area);
        viewHolder.getAddress().setText(localDataSet.get(position).fields.address);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}