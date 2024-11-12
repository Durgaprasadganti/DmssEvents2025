package com.dmss.dmssevent.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.dmss.dmssevent.models.RecentPlayersModel;
import com.dmss.dmssevent.service.RetrofitService;
import com.dmss.dmssevent.service.TotalBookingsApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectPlayerRepository {
    private static SelectPlayerRepository selectPlayerRepository;

    public static SelectPlayerRepository getInstance(){
        if(selectPlayerRepository==null){
            selectPlayerRepository=new SelectPlayerRepository();
        }
        return selectPlayerRepository;
    }

   private static TotalBookingsApi totalBookingsApi;

    public SelectPlayerRepository() {
        totalBookingsApi= RetrofitService.cteateService(TotalBookingsApi.class);
    }

    public static MutableLiveData<RecentPlayersModel> getSelectedPlayersData(String userId, String gameName, JsonObject gameMateIds) {
        final MutableLiveData<RecentPlayersModel> selectedPlayersResponse=new MutableLiveData<>();
        totalBookingsApi.testRecentPlayersListCall(userId,gameName,gameMateIds).enqueue(new Callback<RecentPlayersModel>() {
            @Override
            public void onResponse(Call<RecentPlayersModel> call, Response<RecentPlayersModel> response) {
                selectedPlayersResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RecentPlayersModel> call, Throwable t) {
                selectedPlayersResponse.setValue(null);
            }
        });
    return selectedPlayersResponse;
    }
}
