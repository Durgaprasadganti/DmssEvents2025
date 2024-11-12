package com.dmss.dmssevent.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.dmss.dmssevent.R;
import com.dmss.dmssevent.adapters.ListOfTotalMatchesAdapter;
import com.dmss.dmssevent.common.DmsEventsAppController;
import com.dmss.dmssevent.interfaces.WebServiceResponseCallBack;
import com.dmss.dmssevent.models.TodaySinglesListModel;

import java.util.ArrayList;


public class TodayMatchesFragment extends Fragment implements WebServiceResponseCallBack {
    View rootView;
    ListView listViewMatches;
    ListOfTotalMatchesAdapter listOfTotalMatchesAdapter;
    DmsEventsAppController controller;
    ProgressDialog progressDialog;
    LinearLayout emptyElement, awardDescription;
    TextView retryTextView;
    ArrayList<TodaySinglesListModel> todayListModelArraySinglesList =new ArrayList<TodaySinglesListModel>();
    //String[] titles = {"Table Tennis", "Carroms", "Chess", "Cricket", "Table Tennis", "Carroms", "Chess", "Cricket"};
    //String[] matches = {"Match 1", "Match 2", "Match 3", "Match 4", "Match 5", "Match 6", "Match 7", "Match 8"};

    public TodayMatchesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_todays_match, container, false);
        controller=(DmsEventsAppController)getActivity().getApplicationContext();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading please wait....");
        progressDialog.setIndeterminate(false);
        progressDialog.setCanceledOnTouchOutside(false);
        emptyElement = (LinearLayout) rootView.findViewById(R.id.emptyElement);
        retryTextView = (TextView) rootView.findViewById(R.id.retryTextView);
        listViewMatches = (ListView) rootView.findViewById(R.id.listViewMatches);
        listViewMatches.setEmptyView(rootView.findViewById(R.id.textViewNoResults));
        todayListModelArraySinglesList =controller.getTodayListModelArraySinglesList();
        listOfTotalMatchesAdapter=new ListOfTotalMatchesAdapter(getActivity(), todayListModelArraySinglesList);
        listViewMatches.setAdapter(listOfTotalMatchesAdapter);
        return rootView;
    }

    @Override
    public void onServiceCallSuccess(String result) {

    }

    @Override
    public void onServiceCallFail(String error) {

    }
}
