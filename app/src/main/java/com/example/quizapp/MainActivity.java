package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        drawerLayout = findViewById(R.id.drawer);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.facebookPage) {
                    // Handle Facebook page click
                } else if (id == R.id.website) {
                    // Handle Website click
                } else if (id == R.id.nav_privacy_policy) {
                    // Handle Privacy Policy click
                } else if (id == R.id.nav_terms_conditions) {
                    // Handle Terms and Conditions click
                } else if (id == R.id.more) {
                    // Handle More click
                } else if (id == R.id.nav_rate) {
                    // Handle Rate click
                } else if (id == R.id.nav_share) {
                    // Handle Share click
                }
drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    public void Kotlin(View view) {
        Intent intent=new Intent(MainActivity.this,QuestionActivity5.class);
        startActivity(intent);
    }
    public void CSharp(View view) {
        Intent intent=new Intent(MainActivity.this,QuestionActivity6.class);
        startActivity(intent);
    }
    public void Html(View view) {
        Intent intent=new Intent(MainActivity.this,QuestionActivity4.class);
        startActivity(intent);
    }
    public void Python(View view) {
        Intent intent=new Intent(MainActivity.this,QuestionActivity3.class);
        startActivity(intent);
    }
    public void Cplus(View view) {
        Intent intent=new Intent(MainActivity.this,QuestionActivity2.class);
        startActivity(intent);
    }
    public void C(View view) {
        Intent intent=new Intent(MainActivity.this,QuestionActivity.class);
        startActivity(intent);

    }
}
