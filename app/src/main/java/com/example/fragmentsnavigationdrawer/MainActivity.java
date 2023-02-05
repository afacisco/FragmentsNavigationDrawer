package com.example.fragmentsnavigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

/*
Autor: Juan Francisco Sánchez González
Fecha: 04/02/2023
Clase: Actividad que contiene un Navigation Drawer y que utiliza 3 fragments para cargar el contenido de la interfaz.
 Los elementos del menú lateral harán el reemplazo de los fragmentos en la activity.
*/

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView nav;
    private Fragment fragmentInicio;
    private Fragment fragmentSegundo;
    private Fragment fragmentTercero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciamos los 3 fragmentos y añadimos el 1º a la actividad utilizando la clase FragmentManager
        fragmentInicio = new PrimerFragmento();
        fragmentSegundo = new SegundoFragmento();
        fragmentTercero = new TercerFragmento();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragment, fragmentInicio).commit();

        // Componente NavigatorDrawer
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nav = (NavigationView) findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_item_one:
                        // Reemplazamos el 1º fragmento en la actividad utilizando la clase FragmentManager
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragment, fragmentInicio).commit();
                        break;
                    case R.id.nav_item_two:
                        // Reemplazamos el 2º fragmento en la actividad utilizando la clase FragmentManager
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragment, fragmentSegundo).commit();
                        break;
                    case R.id.nav_item_three:
                        // Reemplazamos el 3º fragmento en la actividad utilizando la clase FragmentManager
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragment, fragmentTercero).commit();
                        break;
                }
                // Close the navigation drawer when an item is selected
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }
}