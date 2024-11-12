package com.dmss.dmssevent;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;

import com.dmss.dmssevent.common.ConstantKeys;
import com.dmss.dmssevent.common.DmsSharedPreferences;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


/**
 * Created by sandeep.kumar on 14-03-2017.
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_main);
        getVersionCode();
        openSplash();
    }

    private void openSplash() {
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (DmsSharedPreferences.isUserLoggedIn(SplashActivity.this)) {
                        boolean status = DmsSharedPreferences.isOwnerLoggedIn(SplashActivity.this);
                        Intent intent;
                        if (status) {
                            intent = new Intent(SplashActivity.this, RemoteControlActivity.class);
                        } else {
                            intent = new Intent(SplashActivity.this, PermissionActivity.class);
                            // intent = new Intent(SplashActivity.this, BookMyGameActivity.class);
                        }
                        startActivity(intent);
                        finish();

                    } else {
                        Intent intent = new Intent(SplashActivity.this, MailValidationActivity.class);
                        startActivity(intent);
                    }
                }
            }
        };
        timerThread.start();

    }

    public void getVersionCode() {
        try {
            PackageInfo pInfo = SplashActivity.this.getPackageManager().getPackageInfo(getPackageName(), 0);
            ConstantKeys.versionCode = "Version  " + pInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {

        super.onNewIntent(intent);


    }

}
