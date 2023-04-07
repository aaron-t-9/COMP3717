package com.bcit.aaron_lab5;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FactsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FactsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "com.bcit.at.3717.lab5.facts";

    // TODO: Rename and change types of parameters
    private Ocean mParam1;

    public FactsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FactsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FactsFragment newInstance(Ocean param1) {
        FactsFragment fragment = new FactsFragment();
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

        View view = inflater.inflate(R.layout.fragment_facts, container, false);
        TextView textView = view.findViewById(R.id.textView_factsFrag_oceanFact);

        if(getArguments() != null) {

            if (mParam1.getName().equals("Pacific")) {
                textView.setText("The Pacific Ocean covers about a third of the Earth’s surface at 165 million square kilometers.");
            }
            else if (mParam1.getName().equals("Atlantic")) {
                textView.setText("The average depth of the Atlantic Ocean is 11,961 feet.");
            }
            else if (mParam1.getName().equals("Indian")) {
                textView.setText("The Indian Ocean provides home to many endangered sea species such as turtles, seals and dugongs (also called sea cows).");
            }

        }

        Button nextFactBtn = (Button) view.findViewById(R.id.button_factsFrag_nextFact);
        nextFactBtn.setOnClickListener(new View.OnClickListener() {
            String oceanName;
            ArrayList<String> facts;
            int factTracker = 0;

            @Override
            public void onClick(View view) {
                if (getArguments() != null) {
                    oceanName = mParam1.getName();
                    facts = generateFacts(oceanName);

                   if (oceanName.equals("Atlantic")) {
                       facts = generateFacts(oceanName);
                    }
                    else if (oceanName.equals("Indian")) {
                       facts = generateFacts(oceanName);
                    }
                }
                else {
                    facts = generateFacts("Pacific");
                }

                textView.setText(facts.get(factTracker));
                factTracker++;
                if (factTracker == 3) {
                    factTracker = 0;
                }
            }
        });

        return view;
    }

    private static ArrayList<String> generateFacts(String oceanName) {

        if (oceanName.equals("Atlantic")) {
            ArrayList<String> facts = new ArrayList<>();
            facts.add("The Atlantic Ocean is the second largest ocean and contains 23.3% of all ocean water on our planet.");
            facts.add("The Atlantic Ocean is divided into two parts, the North Atlantic Ocean and the South Atlantic Ocean.");
            facts.add("The average depth of the Atlantic Ocean is 11,961 feet.");
            return facts;
        }
        else if (oceanName.equals("Indian")) {
            ArrayList<String> facts = new ArrayList<>();
            facts.add("The Indian Ocean is the youngest of the major oceans.");
            facts.add("The average temperature of the Indian Ocean is 22 degrees celcius.");
            facts.add("The Indian Ocean provides home to many endangered sea species such as turtles, seals and dugongs (also called sea cows).");
            return facts;
        }
        else {
            ArrayList<String> facts = new ArrayList<>();
            facts.add("The Pacific Ocean is the largest ocean and contains 50.1% of all ocean water on our planet.");
            facts.add("The 'Ring of Fire' is a ring of volcanoes found within the Pacific Ocean ans is prone to earthquakes.");
            facts.add("The Pacific Ocean covers about a third of the Earth’s surface at 165 million square kilometers.");
            return facts;
        }
    }
}