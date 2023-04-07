package com.bcit.aaron_midterm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class InventoryViewAdapter extends RecyclerView.Adapter<InventoryViewAdapter.ViewHolder> {

    private ArrayList<Hippo> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * This template comes with a TextView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        private final TextView tv_nameHeader;
        private final TextView tv_hippoName;

        private final TextView tv_ageHeader;
        private final TextView tv_hippoAge;

        private final TextView tv_favFoodHeader;
        private final TextView tv_hippoFavFood;

        public ViewHolder(View view) {
            super(view);

            imageView = view.findViewById(R.id.image);

            tv_nameHeader = view.findViewById(R.id.textView_inv_nameHeader);
            tv_hippoName = view.findViewById(R.id.textView_inv_hippoName);

            tv_ageHeader = view.findViewById(R.id.textView_inv_ageHeader);
            tv_hippoAge = view.findViewById(R.id.textView_inv_hippoAge);

            tv_favFoodHeader = view.findViewById(R.id.textView_inv_favFoodHeader);
            tv_hippoFavFood = view.findViewById(R.id.textView_inv_hippoFavFood);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTv_nameHeader() {
            return tv_nameHeader;
        }
        public TextView getTv_hippoName() {
            return tv_hippoName;
        }

        public TextView getTv_ageHeader() {
            return tv_ageHeader;
        }
        public TextView getTv_hippoAge() {
            return tv_hippoAge;
        }

        public TextView getTv_favFoodHeader() {
            return tv_favFoodHeader;
        }
        public TextView getTv_hippoFavFood() {
            return tv_hippoFavFood;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public InventoryViewAdapter(ArrayList<Hippo> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_inventory, viewGroup, false); //error here should be expected, this is a template

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTv_hippoName().setText(localDataSet.get(position).getName());
        viewHolder.getTv_hippoAge().setText(localDataSet.get(position).getAge());
        viewHolder.getTv_hippoFavFood().setText(localDataSet.get(position).getFood());

        viewHolder.getImageView().setImageResource(localDataSet.get(position).getResId());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}