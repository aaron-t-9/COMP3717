package com.bcit.aaron_lab7;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainPresenter {

    public interface View {
        void onUpdateRecycler(List<OffLeashParks.Record> areas);
    }

    private final MainModel mainModel;
    private final View view;

    public MainPresenter(View view, MainModel mainModel) {
        this.mainModel = mainModel;
        this.view = view;
    }

    public void getDataFromModel() {    // gets data from the model and calls onUpdateRecycler

         List<OffLeashParks.Record> areas = mainModel.getData();
         view.onUpdateRecycler(areas);
    }

}
