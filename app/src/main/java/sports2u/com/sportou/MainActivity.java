package sports2u.com.sportou;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import sports2u.com.sportou.fragments.CoachFragment;
import sports2u.com.sportou.fragments.InstructorListFragment;
import sports2u.com.sportou.fragments.LoginFragment;
import sports2u.com.sportou.fragments.MainFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(DataController.getInstance().isLoggedIn())
            setContentView(R.layout.activity_main_logged_in);
        else
            setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_holder, MainFragment.newInstance())
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.nav_home:
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_holder, MainFragment.newInstance())
                        .commit();
                break;

            case R.id.nav_login:
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_holder, LoginFragment.newInstance())
                        .commit();
                break;

            case R.id.nav_logout:
                DataController.getInstance().setLoginStatus(false);
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                recreate();
                Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void Login(View view) {
        DataController.getInstance().setLoginStatus(true);
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        recreate();
        Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show();
    }

    public void ShowInstructor(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_holder, CoachFragment.newInstance())
                .commit();
    }

    public void ShowSportsDialog(final View view) {
        final CharSequence[] sports = DataController.getSports();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select a sport");
        builder.setItems(sports, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((EditText) view).setText(sports[i]);
            }
        });
        builder.show();
    }

    public void ShowLocationDialog(final View view) {
        final CharSequence[] locations = DataController.getLocations();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select a location");
        builder.setItems(locations, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((EditText) view).setText(locations[i]);
            }
        });
        builder.show();
    }

    public void GetGPSLocation(View view) {
        ((EditText) findViewById(R.id.tbx_location)).setText("iCity");
    }
}
