package com.example.cookrecipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    MyiceFragment myiceFragment;
    ShopFragment shopFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        homeFragment = new HomeFragment();
        myiceFragment = new MyiceFragment();
        shopFragment = new ShopFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                switch(item.getItemId()){
                  case R.id.home :
                      getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();
                    break;
                  case R.id.myice:
                    getSupportFragmentManager().beginTransaction().replace(R.id.containers, myiceFragment).commit();
                    break;
                  case R.id.shop :
                    getSupportFragmentManager().beginTransaction().replace(R.id.containers, shopFragment).commit();
                    break;
                }
                return false;
            }
        });
    }
}