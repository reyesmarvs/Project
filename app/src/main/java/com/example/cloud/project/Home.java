package com.example.cloud.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Home extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListView;

    String[] bldgNames = {"Albertus Magnus", "Alfredo M. Velayo", "Beato Angelico", "Benavides Building", "Buenaventura G. Paredes, O.P.",
            "Main Building", "Miguel de Benavides Library", "Roque Ruano", "St. Martin de Porres", "St. Raymund de Penafort"};
    int[] bldgPics = {R.drawable.albertus,
            R.drawable.amv,
            R.drawable.beato,
            R.drawable.benavides,
            R.drawable.bgpop,
            R.drawable.main,
            R.drawable.miguel,
            R.drawable.roque,
            R.drawable.martin,
            R.drawable.raymund};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        mListView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(Home.this, bldgNames, bldgPics);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(Home.this, DetailActivity.class);
                mIntent.putExtra("countryName", bldgNames[i]);
                mIntent.putExtra("countryFlag", bldgPics[i]);
                startActivity(mIntent);
            }
        });
    }
}
