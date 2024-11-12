package com.dmss.dmssevent.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookMyGameModel {

    @SerializedName("Status")
    @Expose
    private String Status;

    @SerializedName("Result")
    @Expose
    private TotalResultBookMyGameModel Result = null;


    public String getStatus() {
        return Status;
    }


    public void setStatus(String status) {
        Status = status;
    }

    public TotalResultBookMyGameModel getResult() {
        return Result;
    }

    public void setResult(TotalResultBookMyGameModel result) {
        Result = result;
    }
}
