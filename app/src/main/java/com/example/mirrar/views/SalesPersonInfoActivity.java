package com.example.mirrar.views;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mirrar.R;
import com.example.mirrar.databinding.SaleInfoLayoutBinding;
import com.example.mirrar.models.Items;
import com.example.mirrar.viewmodel.MainViewModel;
import com.example.mirrar.viewmodel.SaleInfoViewModel;

import java.util.ArrayList;

public class SalesPersonInfoActivity extends AppCompatActivity {

    SaleInfoLayoutBinding saleInfoLayoutBinding;
    SaleInfoViewModel saleInfoViewModel;


    ArrayList<Items> itemsArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        saleInfoLayoutBinding = DataBindingUtil.setContentView(this, R.layout.sale_info_layout);
        itemsArrayList = (ArrayList<Items>) getIntent().getSerializableExtra("itemsList");
        String total = String.valueOf(getIntent().getLongExtra("total", 0));

        saleInfoViewModel = new SaleInfoViewModel(this, itemsArrayList, total);
        saleInfoLayoutBinding.setInfoModel(saleInfoViewModel);
        saleInfoLayoutBinding.executePendingBindings();

    }
}
