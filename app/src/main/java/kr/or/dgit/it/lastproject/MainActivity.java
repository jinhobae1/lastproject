package kr.or.dgit.it.lastproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = findViewById(R.id.viewpager);





      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.home) {
            viewPager.setAdapter(new MyHome(getSupportFragmentManager()));
        } else if (id == R.id.print) {
            /*   fn.beginTransaction().replace(R.id.drawer_layout, new simpleprinttest()).addToBackStack(null).commit();*/
            viewPager.setAdapter(new MyColorPagerAdapter(getSupportFragmentManager()));
        } else if (id == R.id.simpletest) {
            /*  fn.beginTransaction().replace(R.id.drawer_layout, new funtest()).addToBackStack(null).commit();*/
            viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        } else if (id == R.id.sentencetest) {
            viewPager.setAdapter(new Mysentencetest(getSupportFragmentManager()));
        } else if (id == R.id.nav_share) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");

            Intent chooser = Intent.createChooser(intent, "공유");
            startActivity(chooser);


        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        List<Fragment> fragments = new ArrayList<>();
        String titles[] = new String[]{"재미있는 실생활 심리", "재미있는 실생활 심리1", "재미있는 실생활 심리2", "재미있는 실생활 심리3", "재미있는 실생활 심리4", "재미있는 실생활 심리5", "재미있는 실생활 심리6", "재미있는 실생활 심리7", "재미있는 실생활 심리8"};

        public MyPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
            fragments.add(new Funtest());
            fragments.add(new Funtest1());
            fragments.add(new Funtest2());
            fragments.add(new Funtest3());
            fragments.add(new Funtest4());
            fragments.add(new Funtest5());
            fragments.add(new Funtest6());
            fragments.add(new Funtest7());
            fragments.add(new Funtest8());
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragments.get(position);
        }


        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override

        public CharSequence getPageTitle(int position) {
            return titles[position];

        }
    }

    private class MyColorPagerAdapter extends FragmentStatePagerAdapter {
        List<Fragment> fragments = new ArrayList<>();

        public MyColorPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(new Simpleprinttest());
            fragments.add(new Simplecolorprintresult());
            fragments.add(new Simplecolorprintresult2());
            fragments.add(new Simplecolorprintresult3());
            fragments.add(new Simplecolorprintresult4());
            fragments.add(new Simplecolorprintresult5());
            fragments.add(new Simplecolorprintresult6());
            fragments.add(new Simplecolorprintresult7());
            fragments.add(new Simplecolorprintresult8());
            fragments.add(new Simplecolorprintresult9());
            fragments.add(new Simplecolorprintresult10());
            fragments.add(new Simplecolorprintresult11());
            fragments.add(new Simplecolorprintresult12());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    private class MyHome extends FragmentStatePagerAdapter {
        List<Fragment> fragments = new ArrayList<>();

        public MyHome(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
            fragments.add(new Home());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }

    private class Mysentencetest extends FragmentStatePagerAdapter {
        List<Fragment> fragments = new ArrayList<>();

        public Mysentencetest(FragmentManager fm) {
            super(fm);
            fragments.add(new Sentencetest());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
