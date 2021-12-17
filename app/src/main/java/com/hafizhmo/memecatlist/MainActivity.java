package com.hafizhmo.memecatlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] e_names = getResources().getStringArray(R.array.everglow_name);
        String[] e_roles = getResources().getStringArray(R.array.everglow_role);

        ArrayAdapter adapterSingleLine = new ArrayAdapter(this, android.R.layout.simple_list_item_1, e_names);
        ArrayAdapter adapterTwoLines = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, e_names){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View mView = super.getView(position, convertView, parent);

                TextView text1 = mView.findViewById(android.R.id.text1);
                TextView text2 = mView.findViewById(android.R.id.text2);

                text1.setText(e_names[position]);
                text2.setText(e_roles[position]);
                return mView;
            }
        };

        ListView mListView = findViewById(R.id.lv_main);
        mListView.setAdapter(adapterTwoLines);
    }
}