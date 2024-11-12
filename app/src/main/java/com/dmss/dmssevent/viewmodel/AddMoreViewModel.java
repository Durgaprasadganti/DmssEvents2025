package com.dmss.dmssevent.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dmss.dmssevent.common.DmsSharedPreferences;
import com.dmss.dmssevent.models.AddedPlayersModel;
import com.dmss.dmssevent.models.RecentPlayersModel;
import com.dmss.dmssevent.models.ResultListGamesModel;
import com.dmss.dmssevent.models.ResultModelConfirmation;
import com.dmss.dmssevent.models.ResultOFDepartment;
import com.dmss.dmssevent.models.TotalResultBookMyGameModel;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class AddMoreViewModel extends ViewModel {

    private MutableLiveData<RecentPlayersModel> mutableLiveData;
    private MutableLiveData<AddedPlayersModel> mutableLiveDataAdd;
    private MutableLiveData<ResultOFDepartment> mutableLiveDataDepartments;
    private AddMorePlayerRepository addMorePlayerRepository;

    public void init(String callFrom, String searchKeyword){

        addMorePlayerRepository=AddMorePlayerRepository.getInstance();
        if(callFrom.equalsIgnoreCase("searchPlayer")) {
            mutableLiveData = addMorePlayerRepository.getAddMorePlayersData(searchKeyword);
        }
    }
    public void init(String callFrom){

        addMorePlayerRepository=AddMorePlayerRepository.getInstance();
        if(callFrom.equalsIgnoreCase("getDepartment")) {
            mutableLiveDataDepartments = addMorePlayerRepository.getTotalDepartments();
        }
    }

    public void init(String callFrom,int DeptId){

        addMorePlayerRepository=AddMorePlayerRepository.getInstance();
        if(callFrom.equalsIgnoreCase("getPlayersByDepartment")){
            mutableLiveData = addMorePlayerRepository.getPlayersDataByDepart(DeptId);
        }
    }

    public void init(String userId,String callFrom, String gameName, JsonObject GameMateIds){

        addMorePlayerRepository=AddMorePlayerRepository.getInstance();
        if(callFrom.equalsIgnoreCase("selectedplayerAdd")){

            mutableLiveDataAdd=addMorePlayerRepository.getAddedSelectedPlayersData(userId,gameName,GameMateIds);
        }
    }
    public LiveData<RecentPlayersModel> getTotalSelectedPlayers()
    {
        return mutableLiveData;
    }
    public LiveData<ResultOFDepartment> getTotalDetartments()
    {
        return mutableLiveDataDepartments;
    }
    public LiveData<AddedPlayersModel> getAddedTotalSelectedPlayers()
    {
        return mutableLiveDataAdd;
    }

}
