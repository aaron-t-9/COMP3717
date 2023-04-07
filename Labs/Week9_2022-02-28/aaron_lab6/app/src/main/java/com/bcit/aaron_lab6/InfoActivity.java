package com.bcit.aaron_lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = FirebaseFirestore.getInstance();

        getPeople();
    }

    void getPeople() {
        List<Person> people = new ArrayList<Person>();

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Debug", document.getData().toString());

                                people.add(
                                        new Person(
                                                document.getData().get("firstName").toString(),
                                                document.getData().get("lastName").toString(),
                                                document.getData().get("location").toString()
                                        )
                                );
                            }
                        }
                        else {
                            Log.w("Debug", "Error getting documents", task.getException());
                        }

                        Person[] peps = people.toArray(new Person[people.size()]);

                        for (int index = 0; index < peps.length; index++) {
                            System.out.println(peps[index].firstName);
                            System.out.println(peps[index].lastName);
                            System.out.println(peps[index].location);
                            System.out.println();
                        }

                        System.out.println("3142: " + peps.toString());
                        setUpRecycler(peps);

                    }


                });
    }

    public void setUpRecycler(Person[] people) {
        PersonAdapter personAdapter = new PersonAdapter(people);
        RecyclerView recyclerView = findViewById(R.id.recyclerView_info);
        recyclerView.setAdapter(personAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}