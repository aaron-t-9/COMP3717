package com.bcit.aaron_lab6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private Person[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * This template comes with a TextView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView1;
        private final TextView textView2;

        public ViewHolder(View view) {
            super(view);

            textView1 = view.findViewById(R.id.textView_person_nameHere); //error here should be expected, this is a template
            textView2 = view.findViewById(R.id.textView_person_locationHere); //error here should be expected, this is a template
        }

        public TextView getTextView1() {
            return textView1;
        }
        public TextView getTextView2() {
            return textView2;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public PersonAdapter(Person[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_person, viewGroup, false); //error here should be expected, this is a template

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        String firstName = localDataSet[position].getFirstName();
        String lastName = localDataSet[position].getLastName();
        String fullName = firstName + " " + lastName;

        viewHolder.getTextView1().setText(fullName);
        viewHolder.getTextView2().setText(localDataSet[position].getLocation());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}