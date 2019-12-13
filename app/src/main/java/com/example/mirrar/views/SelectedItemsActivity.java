package com.example.mirrar.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mirrar.R;
import com.example.mirrar.adapter.SelectedItemsAdapter;
import com.example.mirrar.databinding.ActivityMainBinding;
import com.example.mirrar.databinding.SelectedLayoutBinding;
import com.example.mirrar.models.Items;
import com.example.mirrar.viewmodel.MainViewModel;

import java.util.ArrayList;

public class SelectedItemsActivity extends AppCompatActivity {

    SelectedLayoutBinding selectedLayoutBinding;
    ArrayList<Items> itemsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectedLayoutBinding = DataBindingUtil.setContentView(this, R.layout.selected_layout);

        itemsArrayList = (ArrayList<Items>) getIntent().getSerializableExtra("itemsList");
        selectedLayoutBinding.total.setText(String.valueOf(getIntent().getLongExtra("total", 0)));

        final double toBePaid = getIntent().getLongExtra("total", 0) + (0.18 * getIntent().getLongExtra("total", 0));
        selectedLayoutBinding.toBePaid.setText(String.valueOf(toBePaid));

        SelectedItemsAdapter selectedItemsAdapter = new SelectedItemsAdapter(itemsArrayList,this);
        selectedLayoutBinding.selectedRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        selectedLayoutBinding.selectedRecyclerview.setAdapter(selectedItemsAdapter);

        selectedLayoutBinding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectedItemsActivity.this, SalesPersonInfoActivity.class);
                intent.putExtra("total", toBePaid);
                intent.putExtra("itemsList", itemsArrayList);
                startActivity(intent);
            }
        });

    }

}
