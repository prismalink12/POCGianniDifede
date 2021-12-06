package com.example.finalprojectnavbar;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView BottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.activ_main, new Crypto_Coins()).commit();

        BottomNavigationView.setSelectedItemId(R.id.crypto_Coins);

        BottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.crypto_Coins:
                        fragment = new Crypto_Coins();
                        break;
                    case R.id.favorites:
                        fragment = new Favorites();
                        break;
                    case R.id.charts:
                        fragment = new Charts();
                        break;
                    case R.id.news:
                        fragment = new News();
                        break;
                    case R.id.sign_Out:
                        fragment = new Sign_Out();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.activ_main, fragment).commit();
                        return true;
            }
        });


    }
}
