package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AllDrinkActivity extends AppCompatActivity {

        private RecyclerView rvAllRest;
        AdapterDrink adapter;
        FirebaseServices fbs;
        ArrayList<Drink> rests;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_drink);

            fbs = FirebaseServices.getInstance();
            rests = new ArrayList<Drink>();
            readData();

            // set up the RecyclerView
            RecyclerView recyclerView;
            recyclerView = findViewById(R.id.img123);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new AdapterDrink(this, rests);
            recyclerView.setAdapter(adapter);
        }

        private void readData() {
            fbs.getFire().collection("restaurants")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    rests.add(document.toObject(Drink.class));
                                }
                            } else {
                                Log.e("AllRestActivity: readData()", "Error getting documents.", task.getException());
                            }
                        }
                    });
        }
    }

