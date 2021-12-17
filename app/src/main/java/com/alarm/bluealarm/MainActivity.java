package com.alarm.bluealarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.alarm.bluealarm.auth.Welcome;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
//     implements NavigationView.OnNavigationItemSelectedListener
    //variables
    private MenuItem logoutBtn;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private BottomNavigationView bottomNavigationView;
    private BottomAppBar bottomAppBar;
    private FloatingActionButton floatingActionButton;


    FirebaseAuth firebaseAuth ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //fragment initialise
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MainViewFragment mainViewFragment = new MainViewFragment();
        fragmentTransaction.replace(R.id.fragmentContainerView, mainViewFragment);

        //addrecords fragment creation
        AddRecords addrecords = new AddRecords();

        //addpills fragment creation
        AddPillsFragment addPillsFragment = new AddPillsFragment();

        //firebase instance
        firebaseAuth = FirebaseAuth.getInstance();
        //Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_main);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomAppBar = findViewById(R.id.bottomAppBar);
        floatingActionButton = findViewById(R.id.fabBtn);

        //Bottom Nav View
        bottomNavigationView.setBackground(null);
        Menu menu = bottomNavigationView.getMenu();
//        bottomNavigationView.getMenu().getItem(2).isEnabled(false);

        //Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Navigation Drawer Menu
        navigationView.bringToFront();
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_close, R.string.nav_open);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();;

        navigationView.setCheckedItem(R.id.homeItem);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.homeItem:
                        break;
                    case R.id.settingItem:
                        break;
                    case R.id.shareItem:
                        break;
                    case R.id.rateItem:
                        break;
                    case R.id.logoutItem:

                        // get logout btn
//                Menu menu = navigationView.getMenu();
//                logoutBtn = menu.findItem(R.id.logoutItem);
//                logoutBtn.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
                        firebaseAuth.signOut();
                        Intent intent = new Intent(MainActivity.this, Welcome.class);
                        startActivity(intent);
                        finish();
                        return true;
//                    }
//                });

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;            }
        });




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                while (true) {
                    switch (item.getItemId()) {
                        case R.id.home_bottom_appbar:
                            fragmentTransaction.replace(R.id.fragmentContainerView, mainViewFragment);
                            menu.findItem(item.getItemId()).setShowAsAction(item.getItemId());
                            break;
                        case R.id.measur_bottom_appbar:

                            fragmentTransaction.replace(R.id.fragmentContainerView, addrecords);

                            menu.findItem(item.getItemId()).setShowAsAction(item.getItemId());

                            //Toast.makeText(MainActivity.this,"Test", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.doctor_bottom_appbar:
                            break;
                        case R.id.date_bottom_appbar:
                            break;
                        case R.id.placeHolder:
                            break;
                    }
                    fragmentTransaction.commit();
                    return true;
                }
            }
        });




        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentTransaction.replace(R.id.fragmentContainerView, addPillsFragment);
                fragmentTransaction.commit();
            }
        });


    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
        super.onBackPressed();
        }
    }


}


