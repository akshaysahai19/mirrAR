package com.example.mirrar.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.SeekBar;

import com.example.mirrar.R;
import com.example.mirrar.databinding.ActivityMainBinding;
import com.example.mirrar.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(this,activityMainBinding);
        activityMainBinding.setMainModel(mainViewModel);
        activityMainBinding.executePendingBindings();

        activityMainBinding.imagesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
//                progress = ((int)Math.round(progress/100))*100;
//                seekBar.setProgress(progress);
                activityMainBinding.imagesValue.setText(String.valueOf(progress));
                mainViewModel.updateItems(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
