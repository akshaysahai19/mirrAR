package com.example.mirrar.viewmodel;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.mirrar.databinding.ActivityMainBinding;
import com.example.mirrar.models.Items;
import com.example.mirrar.views.SelectedItemsActivity;

import java.util.ArrayList;

public class MainViewModel extends BaseObservable {

    private Items items;
    private Context context;
    private ArrayList<Items> itemsArrayList;
    private long total = 0;
    private ActivityMainBinding activityMainBinding;

    public MainViewModel(Context context, ActivityMainBinding activityMainBinding) {
        items = new Items("", "", 0);
        this.activityMainBinding = activityMainBinding;
        this.context = context;
        itemsArrayList = new ArrayList<>();
        itemsArrayList.add(0, new Items("iPad", "NA", 0));
        itemsArrayList.add(1, new Items("Stand", "NA", 0));
        itemsArrayList.add(2, new Items("TV", "NA", 0));
        itemsArrayList.add(3, new Items("Mac Mini", "NA", 0));
        itemsArrayList.add(4, new Items("Processed Images", "NA", 0));
    }

    public void setName(String name) {
        items.setName(name);
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getName() {
        return items.getName();
    }

    public void setValue(String value) {
        items.setValue(value);
        notifyPropertyChanged(BR.value);
    }

    @Bindable
    public String getValue() {
        return items.getValue();
    }

    public void setAmount(long amount) {
        items.setAmount(amount);
        notifyPropertyChanged(BR.amount);
    }

    @Bindable
    public long getAmount() {
        return items.getAmount();
    }


    public void onNextClicked() {
        Intent intent = new Intent(context, SelectedItemsActivity.class);
        intent.putExtra("total", total);
        intent.putExtra("itemsList", itemsArrayList);
        context.startActivity(intent);
    }

    public void oniPadModelClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Select the Model");

        String[] models = {"9.7\"", "10.2\"", "10.5\"", "11\"", "12.9\""};
        builder.setItems(models, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                items = new Items("", "", 0);
                switch (which) {
                    case 0: // 9.7"
                        setValue("9.7\"");
                        setAmount(28000);
                        activityMainBinding.ipadModel.setText("9.7\"");
                        break;
                    case 1: // 10.2"
                        setValue("10.2\"");
                        setAmount(30000);
                        activityMainBinding.ipadModel.setText("10.2\"");
                        break;
                    case 2: // 10.5"
                        setValue("10.5\"");
                        setAmount(55000);
                        activityMainBinding.ipadModel.setText("10.5\"");
                        break;
                    case 3: // 11"
                        setValue("11\"");
                        setAmount(68000);
                        activityMainBinding.ipadModel.setText("11\"");
                        break;
                    case 4: // 12.9"
                        setValue("12.9\"");
                        setAmount(90000);
                        activityMainBinding.ipadModel.setText("12.9\"");
                        break;
                }
                setName("iPad");
                itemsArrayList.set(0, items);
                calculateTotal();
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onStandClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Select the Model");

        String[] models = {"Table Top", "Kiosk"};
        builder.setItems(models, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                items = new Items("", "", 0);
                switch (which) {
                    case 0: // 9.7"
                        setValue("Table Top");
                        setAmount(6000);
                        activityMainBinding.stand.setText("Table Top");
                        break;
                    case 1: // 10.2"
                        setValue("5\" Kiosk");
                        setAmount(10000);
                        activityMainBinding.stand.setText("5\" Kiosk");
                        break;
                }
                setName("Stand");
                itemsArrayList.set(1, items);
                calculateTotal();
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onTVModelClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Select the Model");

        String[] models = {"MI 50\"", "Samsung 43\""};
        builder.setItems(models, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                items = new Items("", "", 0);
                switch (which) {
                    case 0: // 9.7"
                        setValue("MI 50\"");
                        setAmount(30000);
                        activityMainBinding.tvModel.setText("MI 50\"");
                        break;
                    case 1: // 10.2"
                        setValue("Samsung 43\"");
                        setAmount(40000);
                        activityMainBinding.tvModel.setText("Samsung 43\"");
                        break;
                }
                setName("TV");
                itemsArrayList.set(2, items);
                calculateTotal();
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onMacModelClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Select the Model");

        String[] models = {"38000", "70000"};
        builder.setItems(models, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                items = new Items("", "", 0);
                switch (which) {
                    case 0: // 9.7"
                        setValue("38000");
                        setAmount(38000);
                        activityMainBinding.macModel.setText("38000");
                        break;
                    case 1: // 10.2"
                        setValue("70000");
                        activityMainBinding.macModel.setText("70000");
                        setAmount(70000);
                        break;
                }
                setName("Mac Mini");
                itemsArrayList.set(3, items);
                calculateTotal();
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void updateItems(int value) {
        setValue(String.valueOf(value));
        setAmount(value * 150);
        setName("Processed Images");
        itemsArrayList.set(4, items);

        calculateTotal();
    }

    private void calculateTotal() {
        total = 0;
        for (int i = 0; i < itemsArrayList.size(); i++) {
            if (itemsArrayList.get(i).getAmount() > 0) {
                Toast.makeText(context, "value - " + i, Toast.LENGTH_SHORT).show();
                total += itemsArrayList.get(i).getAmount();
            }
        }
        activityMainBinding.total.setText(String.valueOf(total));

    }
}
