package com.example.muf_projekt_v11;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.muf_projekt_v11.data.DatenInformation;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
        ).get(MainViewModel.class);

        final ListView listView = findViewById(R.id.listview);

        mainViewModel.datenLiveData.observe(this,(datenInformation) -> {
            ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datenInformation.getDatenframe());
            listView.setAdapter(adapter);

        });


    }
}
