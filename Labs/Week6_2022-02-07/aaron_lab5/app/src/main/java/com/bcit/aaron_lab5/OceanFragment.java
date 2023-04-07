package com.bcit.aaron_lab5;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OceanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OceanFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "com.bcit.at.3717.lab5.ocean";

    // TODO: Rename and change types of parameters
    private Ocean mParam1;

    public OceanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment OceanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OceanFragment newInstance(Ocean param1) {
        OceanFragment fragment = new OceanFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (Ocean) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ocean, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.textview_oceanFrag_oceanName);
        ImageView imageView = view.findViewById(R.id.imageView_oceanFrag_oceanImage);

        if (getArguments() != null) {
            String oceanName = mParam1.getName();
            textView.setText(oceanName);

            int resourceId = mParam1.getResourceId();

            if (resourceId == 700013) {
                imageView.setImageResource(R.drawable.atlantic_ocean);
            }
            else if (resourceId == 700057) {
                imageView.setImageResource(R.drawable.indian_ocean);
            }
            else if (resourceId == 700085) {
                imageView.setImageResource(R.drawable.pacific_ocean);
            }

        }
    }
}