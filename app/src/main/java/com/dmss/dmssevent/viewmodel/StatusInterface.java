package com.dmss.dmssevent.viewmodel;

import com.dmss.dmssevent.models.TotalBookingGamesResonse;

public interface StatusInterface {

    public void onSuccess(TotalBookingGamesResonse gamesResonse);

    public void onError(String error);
}
