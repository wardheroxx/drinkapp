package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AllDrinkActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    AdapterDrink adapter;
    FirebaseServices fbs;
    ArrayList<Drink> drinks;
    MyCallback myCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_drink);

        fbs = FirebaseServices.getInstance();
        drinks = new ArrayList<Drink>();
        readData();
        myCallback = new MyCallback() {
            @Override
            public void onCallback(List<Drink> attractionsList) {

            }
        };

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterDrink(this, drinks);
        recyclerView.setAdapter(adapter);
    }

    private void readData() {
        try {

            fbs.getFire().collection("DRINKS")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    drinks.add(document.toObject(Drink.class));
                                }

                                myCallback.onCallback(drinks);
                            } else {
                                Log.e("AllDrinkActivity: readData()", "Error getting documents.", task.getException());
                            }
                        }
                    });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "error reading!" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}

