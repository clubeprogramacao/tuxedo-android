package com.fcouceiro.tuxedo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class SuitsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suits);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new SuitsAdapter(this, getDataSet()));
        mRecyclerView.setHasFixedSize(true);
    }

    private List<SuitSchema> getDataSet(){
        List<SuitSchema> dataSet = new ArrayList<>();
        dataSet.add(new SuitSchema("Tuxedo #1", "http://www.mytuxedocatalog.com/wp-content/uploads/C8852.jpg"));
        dataSet.add(new SuitSchema("Tuxedo #2", R.drawable.tuxedo2));
        dataSet.add(new SuitSchema("Tuxedo #3", R.drawable.tuxedo3));
        dataSet.add(new SuitSchema("Tuxedo #4", R.drawable.tuxedo4));

        return dataSet;
    }
}
