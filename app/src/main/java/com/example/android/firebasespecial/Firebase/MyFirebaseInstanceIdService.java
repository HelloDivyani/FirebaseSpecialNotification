package com.example.android.firebasespecial.Firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Divyani on 08-10-2017.
 */
public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String  TAG="MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        String recent_token = FirebaseInstanceId.getInstance().getToken();

        Log.d(TAG,"Refreshed Token"+recent_token);
    }
    private void sendregisterationTokenToServer(String token)
    {
        // implement this method to store token on server

    }


}