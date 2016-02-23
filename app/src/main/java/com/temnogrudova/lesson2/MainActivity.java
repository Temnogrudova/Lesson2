package com.temnogrudova.lesson2;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ActionMode actionMode;
    Context context;

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;

        btn = (Button) findViewById(R.id.btn);
        registerForContextMenu(btn);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Hello world!", Toast.LENGTH_SHORT).show();
                if (actionMode == null)
                    actionMode = startSupportActionMode(callback);
                else
                    actionMode.finish();

            }
        };
        btn.setOnClickListener(onClickListener);

        //создаем спсиок имен
        ArrayList<String> names = new ArrayList<String>();
        names.add("Иван");
        names.add("Марья");
        names.add("Петр");
        names.add("Антон");
        names.add("Даша");
        names.add("Борис");
        names.add("Катя");
        names.add("Саша");
        names.add("Вова");
        names.add("Сергей");
        names.add("Коля");
        names.add("Юля");

        // находим список
        final ListView lvMain = (ListView) findViewById(R.id.lvMain);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);

        //обработка нажатия на элемент
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private ActionMode.Callback callback = new ActionMode.Callback() {

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_action_mode, menu);
            return true;
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case  R.id.action_set_red :{
                    btn.setTextColor(Color.RED);
                    break;
                }
                case  R.id.action_set_green:{
                    btn.setTextColor(Color.GREEN);
                    break;
                }
                case  R.id.action_set_blue:{
                    btn.setTextColor(Color.BLUE);
                    break;
                }
            }
            return false;
        }

        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }

    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case  R.id.action_open :{
                Toast.makeText(this,R.string.action_open, Toast.LENGTH_SHORT).show();
                break;
            }
            case  R.id.action_settings :{
                Toast.makeText(this,R.string.action_settings, Toast.LENGTH_SHORT).show();
                break;
            }
            case  R.id.action_exit:{
                Toast.makeText(this,R.string.action_exit, Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()) {
            case R.id.btn:
                getMenuInflater().inflate(R.menu.menu_context, menu);
                break;
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.action_set_red :{
                btn.setTextColor(Color.RED);
                break;
            }
            case  R.id.action_set_green:{
                btn.setTextColor(Color.GREEN);
                break;
            }
            case  R.id.action_set_blue:{
                btn.setTextColor(Color.BLUE);
                break;
            }
        }
        return super.onContextItemSelected(item);
    }
}
