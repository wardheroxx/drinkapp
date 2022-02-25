package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsDrinkAc extends AppCompatActivity {


    private TextView tvName, tvNum, tvLiters, tvprice;
    private ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_drink);

        connectComponents();
        Intent i = this.getIntent();
        Drink drnk= (Drink) i.getSerializableExtra("drnk");

        tvName.setText(drnk.getName());
        tvNum.setText(drnk.getNum());
        tvLiters.setText(drnk.getLiters());
        tvprice.setText(drnk.getPrice());
        Picasso.get().load(drnk.getPhoto()).into(ivPhoto);

    }

    private void connectComponents() {
        tvName = findViewById(R.id.textView2);
        tvNum = findViewById(R.id.textView4);
        tvLiters = findViewById(R.id.textView3);
        tvprice = findViewById(R.id.textView);
        ivPhoto = findViewById(R.id.imageView2);
    }
}