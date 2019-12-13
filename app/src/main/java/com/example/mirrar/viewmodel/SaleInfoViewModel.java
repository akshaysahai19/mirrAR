package com.example.mirrar.viewmodel;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.mirrar.R;
import com.example.mirrar.models.Items;
import com.example.mirrar.models.SaleInfo;

import java.util.ArrayList;

public class SaleInfoViewModel extends BaseObservable {

    private SaleInfo saleInfo;
    private Context context;
    private ArrayList<Items> itemsArrayList = new ArrayList<>();
    private String total = "0";

    public SaleInfoViewModel(Context context, ArrayList<Items> itemsArrayList, String total) {
        this.context = context;
        this.itemsArrayList = itemsArrayList;
        this.total = total;
        saleInfo = new SaleInfo("", "", "", "", "", "", "", "");
    }

    public String getSalesPersonName() {
        return saleInfo.getSales_person_name();
    }

    public void setSalesPersonName(String sales_person_name) {
        saleInfo.setSales_person_name(sales_person_name);
    }

    public String getClientName() {
        return saleInfo.getClient_name();
    }

    public void setClientName(String client_name) {
        saleInfo.setClient_name(client_name);
    }

    public String getBrandName() {
        return saleInfo.getBrand_name();
    }

    public void setBrandName(String brand_name) {
        saleInfo.setBrand_name(brand_name);
    }

    public String getEmail() {
        return saleInfo.getEmail();
    }

    public void setEmail(String email) {
        saleInfo.setEmail(email);
    }

    public String getMobileNumber() {
        return saleInfo.getMobile_number();
    }

    public void setMobileNumber(String mobile_number) {
        saleInfo.setMobile_number(mobile_number);
    }

    public String getAddress() {
        return saleInfo.getAddress();
    }

    public void setAddress(String address) {
        saleInfo.setAddress(address);
    }

    public String getPaymentAmount() {
        return saleInfo.getPayment_amount();
    }

    public void setPaymentAmount(String payment_amount) {
        saleInfo.setPayment_amount(payment_amount);
    }

    public String getPaymentMode() {
        return saleInfo.getPayment_mode();
    }

    public void setPaymentMode(String payment_mode) {
        saleInfo.setPayment_mode(payment_mode);
    }

    public void onSendClicked() {
        String[] TO = {"akshay95sahai@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
//        emailIntent.setPackage("com.google.android.gm");
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        String body = "PFA Detailed Estimate - \n\n\n" +
                "Sales Person Name - " + getSalesPersonName() + "\n" +
                "Client Name - " + getClientName() + "\n" +
                "Brand Name - " + getBrandName() + "\n" +
                "E-mail ID - " + getEmail() + "\n" +
                "Mobile Number - " + getMobileNumber() + "\n" +
                "Address - " + getAddress() + "\n" +
                "Advance Payment Amount - " + getPaymentAmount() + "\n" +
                "Advance Payment Mode - " + getPaymentMode() + "\n\n" +
                "Selected Items Details\n" +
                itemsArrayList.get(0).getName() + "- " + itemsArrayList.get(0).getValue() + " : " + itemsArrayList.get(0).getAmount() + "\n" +
                itemsArrayList.get(1).getName() + "- " + itemsArrayList.get(1).getValue() + " : " + itemsArrayList.get(1).getAmount() + "\n" +
                itemsArrayList.get(2).getName() + "- " + itemsArrayList.get(2).getValue() + " : " + itemsArrayList.get(2).getAmount() + "\n" +
                itemsArrayList.get(3).getName() + "- " + itemsArrayList.get(3).getValue() + " : " + itemsArrayList.get(3).getAmount() + "\n" +
                itemsArrayList.get(4).getName() + "- " + itemsArrayList.get(4).getValue() + " : " + itemsArrayList.get(4).getAmount() + "\n\n" +
                "Kindly let us know if you have any question for us.\n" +
                "Thanks";

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, body);

        try {
            context.startActivity(emailIntent);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(context, R.string.no_email_client, Toast.LENGTH_SHORT).show();
        }
    }

}
