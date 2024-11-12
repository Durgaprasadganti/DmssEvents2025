package com.dmss.dmssevent.interfaces;

import com.dmss.dmssevent.models.SelectedPlayersResultModel;
import com.google.gson.JsonArray;

import java.util.ArrayList;

public interface SelectedPlayersInterface {

    public void onClick(int position, JsonArray jsonElements, ArrayList<SelectedPlayersResultModel> selectedPlayersResultModelArrayList);
}
