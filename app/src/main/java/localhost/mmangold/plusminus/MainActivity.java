package localhost.mmangold.plusminus;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import android.app.Activity;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.app.ListActivity;
import android.widget.ListView;

import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // List items
        final ListView listview = (ListView) findViewById(R.id.listView);
        String[] friends = new String[] { "Michel","Hannes","Katha","Anki","Alex","Marcel",
                "Matthias","Peter","James","Ella","Mia","Sarah","Lukas","Max","Köln","Polizei","Pascha" };
        // TODO eigenen adapter schreiben für eigenes list layout
        // http://www.vogella.com/tutorials/AndroidListView/article.html
        // http://www.softwarepassion.com/android-series-custom-listview-items-and-adapters/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, friends);
        listview.setAdapter(adapter);

        // TODO Click List item
        /*
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

        // Floating Action Menu buttons
        final FloatingActionButton fab_add_friend = (FloatingActionButton) findViewById(R.id.fab_add_friend);
        fab_add_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab_add_friend.setTitle("Add Friend clicked");
            }
        });

        final View fab_add_payment = findViewById(R.id.fab_add_payment);

        /* // Button C can hide or show another button B
        FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
        actionC.setTitle("Hide/Show Action above");
        actionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });
        fab.addButton(actionC);
        */

        FloatingActionsMenu fab = (FloatingActionsMenu) findViewById(R.id.fab_multiple_actions);

        // Example snackbar usage (popup message from below)
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
