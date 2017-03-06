package com.alro2025.mascotas30;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.alro2025.mascotas30.adapter.PageAdapter;
import com.alro2025.mascotas30.fragments.PerfilFragment;
import com.alro2025.mascotas30.fragments.RVFragment;

import java.util.ArrayList;

import static com.alro2025.mascotas30.R.menu.top5;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        context = getApplicationContext();

        setUpViewPager();

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(top5, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        switch (item.getItemId()) {
            case R.id.btnStar:

                Intent intent = new Intent(this, ranking.class);
                startActivity(intent);
                return false;

            case R.id.mcontacto:
                Intent contact = new Intent(this, Contacto.class );
                startActivity(contact);
                return true;

            case R.id.mBiografia:
                Intent mibio = new Intent(this, Biografia.class );
                startActivity(mibio);
                return true;

        }


        return super.onOptionsItemSelected (item);
    }

    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RVFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        //Mostramos los iconos de los fragments
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);


    }



}

