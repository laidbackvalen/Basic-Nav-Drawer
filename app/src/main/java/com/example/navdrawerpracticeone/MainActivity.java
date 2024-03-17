package com.example.navdrawerpracticeone;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView productTextview, homeTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        productTextview = findViewById(R.id.productTextView);
        homeTextview = findViewById(R.id.homeTextview);

        productTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productTextview.setBackgroundColor(WHITE);
                productTextview.setTextColor(BLACK);

                homeTextview.setBackgroundColor(BLACK);
                homeTextview.setTextColor(WHITE);

            }
        });
        homeTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productTextview.setBackgroundColor(BLACK);
                productTextview.setTextColor(WHITE);

                homeTextview.setBackgroundColor(WHITE);
                homeTextview.setTextColor(BLACK);
            }
        });

    }

    //OUTSIDE ONCREATE
    public void openDrawer(View view) {   //this method is called on a tool bar layout imageview with burgerMenu
//        openDrawer(drawerLayout);
        drawerLayout.openDrawer(GravityCompat.START);
    }

//    private void openDrawer(DrawerLayout drawerLayout) {
//
//    }

    private void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onPause() {
        closeDrawer(drawerLayout);
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
        super.onBackPressed();
        }
    }


}