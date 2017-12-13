package com.sheygam.masa_2017_13_12;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, View.OnClickListener {

    private String[] names = {
            "Vasya",
            "Petya",
            "Vova",
            "Tanya",
            "Sofa",
            "Dima",
            "Kolya",
            "Masha"
    };
    private String[] names1 = {
            "Vasya",
            "Petya",
            "Vova",
            "Tanya",
            "Sofa",
            "Dima",
            "Kolya",
            "Masha"
    };
    private LinearLayout listContainer;
    private MyAdapter adapter;
    private Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = findViewById(R.id.add_btn);
//        listContainer = findViewById(R.id.list_container);
//        for (int i = 0; i < names.length; i++){
//            TextView row = new TextView(this);
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200);
//            layoutParams.gravity = Gravity.CENTER_VERTICAL;
//            row.setLayoutParams(layoutParams);
//            row.setText(names[i]);
//            row.setTextSize((float)22.0);
//            listContainer.addView(row);
//        }
        ListView myList = findViewById(R.id.my_list);
        adapter = new MyAdapter();
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(this);
        myList.setOnItemLongClickListener(this);
        addBtn.setOnClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = (String) adapter.getItem(position);
        Toast.makeText(this, "Was clicked " + name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        String name = (String) adapter.getItem(position);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Delete item")
                .setMessage("Are you sure you want remove this name?")
                .setIcon(getResources().getDrawable(android.R.drawable.ic_dialog_alert))
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.remove(position);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false)
                .create();
        dialog.show();
        return false;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_btn){
            View view = LayoutInflater.from(this).inflate(R.layout.add_dialog_view,null);
            final EditText inputName = view.findViewById(R.id.input_name);

            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Add name")
                    .setView(view)
                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String name = inputName.getText().toString();
                            adapter.addName(name);
                        }
                    })
                    .setNegativeButton("Cancel",null)
                    .create();
            dialog.show();
        }
    }
}
