package com.dpaulb.paul.optionmenu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.dpaulb.paul.optionmenu.listview.ListItem;
import com.dpaulb.paul.optionmenu.listview.ListViewAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView names;
//    private ArrayList<ListItem> arrayList;
//    private ListViewAdapter listViewAdapter;

    private TableLayout insertTable;
    private Button cancelButton;
    private Button okButton;
    private EditText inputName;


    final static int INSERT_NAME = 1;
    final static int STYLE_MENU = 2;
    final static int STYLE_BOLD = 3;
    final static int STYLE_ITALIC = 4;
    final static int STYLE_NORMAL = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = (TextView) findViewById(R.id.names);
        insertTable = (TableLayout) findViewById(R.id.insertTable);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        okButton = (Button) findViewById(R.id.okButton);
        inputName = (EditText) findViewById(R.id.inputName);


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertTable.setVisibility(View.INVISIBLE);
                names.setVisibility(View.VISIBLE);
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                arrayList.add(new ListItem(inputName.getText().toString()));
//                listViewAdapter = new ListViewAdapter(MainActivity.this, arrayList);
//                listView.setAdapter(listViewAdapter);
                names.setText(names.getText() + "\n" + inputName.getText().toString());
                insertTable.setVisibility(View.INVISIBLE);
                names.setVisibility(View.VISIBLE);
            }

        });

    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if(names.getText().length() > 0) {
            menu.getItem(1).setEnabled(true);
        } else {
            menu.getItem(1).setEnabled(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, INSERT_NAME, 0, "이름 넣기");

        SubMenu subMenu = menu.addSubMenu("STYLE");
        subMenu.add(1, STYLE_BOLD, Menu.NONE, "BOLD");
        subMenu.add(1, STYLE_ITALIC, Menu.NONE, "ITALIC");
        subMenu.add(1, STYLE_NORMAL, Menu.NONE, "NORMAL");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case INSERT_NAME:
                insertTable.setVisibility(View.VISIBLE);
                names.setVisibility(View.INVISIBLE);
                return true;
            case STYLE_BOLD:
                names.setTypeface(null, Typeface.BOLD);
                return true;
            case STYLE_ITALIC:
                names.setTypeface(null, Typeface.ITALIC);
                return true;
            case STYLE_NORMAL:
                names.setTypeface(null, Typeface.NORMAL);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
