package com.dmss.dmssevent;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.dmss.dmssevent.databinding.ActivityChoosePlayerBinding;
import com.dmss.dmssevent.viewmodel.ChoosePlayerViewMOdelFactory;
import com.dmss.dmssevent.viewmodel.ChoosePlayerViewModel;

public class ChoosePlayerActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView toolbar_title_fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChoosePlayerBinding activityChoosePlayerBinding= DataBindingUtil.setContentView(this,R.layout.activity_choose_player);
        ChoosePlayerViewModel choosePlayerViewModel= ViewModelProviders.of(this,new ChoosePlayerViewMOdelFactory(this)).get(ChoosePlayerViewModel.class);
        activityChoosePlayerBinding.setChoosePlayerViewModel(choosePlayerViewModel);
        intializeUIElements();
    }

    private void intializeUIElements() {
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar_title_fragments=(TextView)toolbar.findViewById(R.id.toolbar_title_fragments);
        toolbar_title_fragments.setText("Choose Players");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
