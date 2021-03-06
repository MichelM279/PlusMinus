package localhost.mmangold.plusminus;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import android.app.Activity;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ListActivity;
import android.widget.ListView;

import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Components
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final RelativeLayout relative_layout = (RelativeLayout) findViewById(R.id.main_inner_relative_layout);
        assert relative_layout != null;
        relative_layout.getBackground().setAlpha(0);
        final ListView list_view = (ListView) findViewById(R.id.main_inner_list_view);
        assert list_view != null;

        // List items
        String[] friends = new String[]{"Michel", "Hannes", "Katha", "Anki", "Alex", "Marcel",
                "Matthias", "Peter", "James", "Ella", "Mia", "Sarah", "Lukas", "Max", "Köln", "Polizei"};
        int[] depts = new int[]{5, -5, 0, 20, 40, 13, 15, 18, 19, 42, 1337, -51, 13, -10, 0, -20};

        // eigenen adapter schreiben für eigenes list layout
        // http://www.vogella.com/tutorials/AndroidListView/article.html
        // http://www.softwarepassion.com/android-series-custom-listview-items-and-adapters/
        FriendListViewAdapter adapter = new FriendListViewAdapter(this, friends, depts);
        list_view.setAdapter(adapter);

        // to-do Click List item
        /*
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            protected void onListItemClick (AdapterView<?> parent, final View view, int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                //String item = (String) getListAdapter().getItem(position); // add "item" to makeText
                Toast.makeText(this, "position" + position + " selected", Toast.LENGTH_LONG).show();
            }
        });
        */

        /*final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }*/

        // Floating Action Menu Buttons
        final FloatingActionButton fab_add_friend = (FloatingActionButton) findViewById(R.id.fab_add_friend);
        assert fab_add_friend != null;
        fab_add_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab_add_friend.setTitle("Add Friend clicked");
            }
        });
        final FloatingActionButton fab_add_payment = (FloatingActionButton) findViewById(R.id.fab_add_payment);
        assert fab_add_payment != null;
        fab_add_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab_add_payment.setTitle("Add Payment clicked");
            }
        });

        // Floating Action Menu Main Button
        final FloatingActionsMenu fab_menu = (FloatingActionsMenu) findViewById(R.id.fab_multiple_actions);
        assert fab_menu != null;
        fab_menu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                relative_layout.getBackground().setAlpha(240);
                list_view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        fab_menu.collapse();
                        return true;
                    }
                });
            }

            @Override
            public void onMenuCollapsed() {
                relative_layout.getBackground().setAlpha(0);
                list_view.setOnTouchListener(null);
            }

            /*
            @Override
            public boolean onBackPressed() {
                if (fab_menu.isExpanded()) {
                    fab_menu.collapse();
                    return true;
                } else {
                    return super.onBackPressed();
                }
            }
            */


        });


        // Example snackbar usage (popup message from below)
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    // Menu top bar
    // Menu icons are inflated just as they were with actionbar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_settings was selected
            case R.id.action_sort_alph:
                Toast.makeText(this, "Alph selected", Toast.LENGTH_SHORT).show();
                //menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_menu_manage));
                menu.getItem(1).setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.common_ic_googleplayservices, null));
                break;
            case R.id.action_sort_num:
                Toast.makeText(this, "Num selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return true;
    }

    // Override back to not close App
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "There's no going back from here. Never. Ever. Maybe soon.", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://localhost.mmangold.plusminus/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://localhost.mmangold.plusminus/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
