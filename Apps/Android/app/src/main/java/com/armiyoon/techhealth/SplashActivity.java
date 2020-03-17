package com.armiyoon.techhealth;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.widget.TextView;

import com.armiyoon.techhealth.model.phone.SaveStatuses;


public class SplashActivity extends AppCompatActivity {

    TextView tv;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);

        if(!checkPermission())
            startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));
        else {
            new SaveStatuses(this);
            tv.setText("added data");
        }
    }

    private boolean checkPermission(){
        AppOpsManager appOps = (AppOpsManager) this.getSystemService(Context.APP_OPS_SERVICE);
        assert appOps != null;
        int mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, Process.myUid(), this.getPackageName());
        return (mode == AppOpsManager.MODE_ALLOWED);
    }



}
