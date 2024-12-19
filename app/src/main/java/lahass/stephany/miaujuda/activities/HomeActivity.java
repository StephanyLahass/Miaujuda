package lahass.stephany.miaujuda.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import lahass.stephany.miaujuda.R;
import lahass.stephany.miaujuda.fragments.FavoritosFragment;
import lahass.stephany.miaujuda.fragments.HomeFragment;
import lahass.stephany.miaujuda.fragments.MeusPetsFragment;
import lahass.stephany.miaujuda.fragments.PerdidosFragment;
import lahass.stephany.miaujuda.fragments.PerfilFragment;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    HomeFragment homeFragment = new HomeFragment();
    PerdidosFragment perdidosFragment = new PerdidosFragment();
    MeusPetsFragment meusPetsFragment = new MeusPetsFragment();
    PerfilFragment perfilFragment = new PerfilFragment();
    FavoritosFragment favoritosFragment = new FavoritosFragment();

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

        // Configurar a BottomNavigationView
        setupBottomNavigation();

        // Configurar a Toolbar
        setupToolbar();

        // Inicializa o fragmento inicial
        setFragment(homeFragment);
    }

    // Método para configurar a BottomNavigationView
    private void setupBottomNavigation() {
        bottomNavigationView = findViewById(R.id.btNav);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    setFragment(homeFragment);
                    return true;
                } else if (itemId == R.id.ajude) {
                    setFragment(perdidosFragment);
                    return true;
                } else if (itemId == R.id.meusPets) {
                    setFragment(meusPetsFragment);
                    return true;
                } else if (itemId == R.id.favoritos) {
                    setFragment(favoritosFragment);
                    return true;
                }
                return false;
            }
        });
    }

    // Método para configurar a Toolbar
    private void setupToolbar() {
        toolbar = findViewById(R.id.tbMain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");  // Definir título vazio, ou o título que você deseja
    }

    // Método para substituir o fragmento
    private void setFragment(androidx.fragment.app.Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.HomeFragContainer, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu); // Menu da Toolbar
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.iconPerfil) {
            setFragment(perfilFragment);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
