package lahass.stephany.miaujuda.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import lahass.stephany.miaujuda.R;
import lahass.stephany.miaujuda.fragments.HomeFragment;
import lahass.stephany.miaujuda.fragments.MeusPetsFragment;
import lahass.stephany.miaujuda.fragments.PerdidosFragment;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    PerdidosFragment perdidosFragment = new PerdidosFragment();
    MeusPetsFragment meusPetsFragment = new MeusPetsFragment();


    @SuppressLint("CommitTransaction")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bottomNavigationView = findViewById(R.id.btNav);

        getSupportFragmentManager().beginTransaction().replace(R.id.HomeFragContainer, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.HomeFragContainer, homeFragment).commit();
                    return true;
                } else if (itemId == R.id.ajude) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.HomeFragContainer, perdidosFragment).commit();
                    return true;
                } else if (itemId == R.id.meusPets) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.HomeFragContainer, meusPetsFragment).commit();
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }



}