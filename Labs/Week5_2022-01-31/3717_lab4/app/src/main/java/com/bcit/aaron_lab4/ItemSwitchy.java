package com.bcit.aaron_lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemSwitchy extends RecyclerView.Adapter<ItemSwitchy.ViewHolder> {

    private String[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * This template comes with a TextView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final Button button;
        private final Switch swtch;

        public ViewHolder(View view) {
            super(view);

            textView = view.findViewById(R.id.textView_itemSwitchy_numberedList);
            button = view.findViewById(R.id.button_itemSwitchy_emoteSwap);
            swtch = view.findViewById(R.id.switch_itemSwitchy_buttonEnabler);
        }

        public TextView getTextView() {
            return textView;
        }
        public Button getButton() { return button; };
        public Switch getSwitch() { return swtch; };
        }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public ItemSwitchy(String[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_switchy, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.getTextView().setText(localDataSet[position]);

        Button btn = viewHolder.getButton();
        Switch swtch = viewHolder.getSwitch();

        btn.setEnabled(false);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (view.getId() == R.id.button_itemSwitchy_emoteSwap) {

                    if (btn.getText().toString().equals("D:")) {
                        btn.setText(":D");
                    }
                    else {
                        btn.setText("D:");
                    }

                }

                if (view.getId() == R.id.switch_itemSwitchy_buttonEnabler) {

                    if (swtch.getText().toString().equals("Disabled")) {
                        swtch.setText("Enabled");
                        btn.setEnabled(true);
                    }
                    else {
                        swtch.setText("Disabled");
                        btn.setText("D:");
                        btn.setEnabled(false);
                    }
                }
            }

        };

        btn.setOnClickListener(onClickListener);
        swtch.setOnClickListener(onClickListener);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}