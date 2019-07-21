package com.example.pitchperfectlyaccuratelypractice.data;

import android.app.Activity;
import android.util.Log;

import org.json.JSONObject;

import java.io.File;
import java.io.InputStream;

public class HistoryData {
    JSONObject history;
    String myJson;
    File directory;
    Activity currentAct;
    private static final String TAG = "HISTORY";

    public HistoryData(Activity ac){
        String json;
        currentAct = ac;
        try{
            directory = ac.getFilesDir();
            Log.v(TAG, ac.fileList()[0]);
            InputStream is = ac.openFileInput("history.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            myJson = new String(buffer, "UTF-8");
            history = new JSONObject(myJson);

        } catch (Exception e) {
            Log.e(TAG, "Couldnt find file, using default");
            try{
//            Log.v(TAG, ac.getAssets().list("history.json"));
                InputStream is = ac.getAssets().open("history.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                myJson = new String(buffer, "UTF-8");
                history = new JSONObject(myJson);
            } catch(Exception s) {
                Log.e(TAG, "Couldnt find file");
            }
        }

    }

    public void addData(int note){
        try{
            history.put("yes", note);
        } catch(Exception e) {
            Log.e(TAG, "Couldnt add data");
        }
        File file = new File(currentAct.getFilesDir(), "history.json");
        Log.e(TAG, "Saved new config");

    }

    public int[] retrieveData(){
        int[] lol = new int[0];
        return lol;
    }

    public void resetData(){

    }

}
