package com.bcit.aaron_lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db;
    String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();
    }

    public void setLocation(String location) {
        System.out.println(location);
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }

    public void addPerson(View view) {
        EditText editTextFirstName = findViewById(R.id.editText_main_firstName);
        EditText editTextLastName = findViewById(R.id.editText_main_lastName);

        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String location = getLocation();

        Person person = new Person(firstName, lastName, location);

        if (!(firstName.equals("")) && !(lastName.equals("")) && location != null) {
            db.collection("users")
                .add(person)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Debug", "DocumentSnapshot added with ID: " + documentReference.getId());
                        Intent intent = new Intent(getBaseContext(), InfoActivity.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Debug", "Error adding document", e);
                    }
                });
        }
    }
}