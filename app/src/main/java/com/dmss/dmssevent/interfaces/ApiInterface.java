package com.dmss.dmssevent.interfaces;

import com.dmss.dmssevent.models.LocationModel;
import com.google.gson.JsonObject;

import java.util.HashMap;

import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {
    @POST("http://www.digitalminds.solutions/DMSSApp/api/login/AddEmpLocation")
    Call<ResponseBody> postLocationLatLong(@Body HashMap<String, String> body);
}
