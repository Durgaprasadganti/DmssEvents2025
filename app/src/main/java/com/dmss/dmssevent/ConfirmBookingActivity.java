package com.dmss.dmssevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.dmss.dmssevent.adapters.ConfirmBookingRecycleViewAdapter;
import com.dmss.dmssevent.databinding.ActivityConfirmBookingBinding;
import com.dmss.dmssevent.viewmodel.ConfirmABookingViewModel;
import com.dmss.dmssevent.viewmodel.ConfirmBookingViewModelFactory;

public class ConfirmBookingActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView confirmBookingRecycleView;
    Toolbar toolbar;
    TextView toolbar_title_fragments,cancelTextView,sendTextView;
    String[] userNames={"Sandeep","JK","Madhu","Bhaggu"};
    ConfirmBookingRecycleViewAdapter confirmBookingRecycleViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityConfirmBookingBinding activityConfirmBookingBinding= DataBindingUtil.setContentView(this,R.layout.activity_confirm_booking);
        ConfirmABookingViewModel confirmABookingViewModel= ViewModelProviders.of(this,new ConfirmBookingViewModelFactory(this)).get(ConfirmABookingViewModel.class);
        activityConfirmBookingBinding.setConfirmBookingViewModel(confirmABookingViewModel);
        intializeUIElements();
    }

    private void intializeUIElements() {
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar_title_fragments=(TextView)toolbar.findViewById(R.id.toolbar_title_fragments);
        toolbar_title_fragments.setText("Confirm Booking");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        confirmBookingRecycleView=findViewById(R.id.confirmBookingRecycleView);
        cancelTextView=findViewById(R.id.cancelTextView);
        sendTextView=findViewById(R.id.sendTextView);
        cancelTextView.setOnClickListener(this);
        sendTextView.setOnClickListener(this);
        confirmBookingRecycleViewAdapter=new ConfirmBookingRecycleViewAdapter(this,userNames);
        confirmBookingRecycleView.setAdapter(confirmBookingRecycleViewAdapter);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancelTextView:

                break;
            case R.id.sendTextView:

                break;
        }
    }
}
