package com.armiyoon.techhealth.model.phone;

import android.annotation.SuppressLint;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

import com.armiyoon.techhealth.model.database.model.Events;
import com.armiyoon.techhealth.model.database.model.Status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GetStatus {

    private Context context;
    GetStatus(Context context){
        this.context=context;
    }

    UsageEvents getStatus(int past){
        UsageStatsManager statsManager= getUsageStatusManager();
        Calendar calendar=Calendar.getInstance();
        long endTime=calendar.getTimeInMillis();
        calendar.add(Calendar.DAY_OF_WEEK,-past);
        long startTime=calendar.getTimeInMillis();
        assert statsManager != null;
        return statsManager.queryEvents(startTime,endTime);
    }

    @SuppressLint("SimpleDateFormat")
    List<Events> convertEventStatus(UsageEvents events){
        List<String> sysPck=getSysPckName();
        UsageEvents.Event e=new UsageEvents.Event();
        List<Events> eventCls=new ArrayList<>();
        String dateString = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format((double) Calendar.getInstance().getTimeInMillis());
        while (events.getNextEvent(e)){
            if(sysPck.contains(e.getPackageName()))
                eventCls.add(new Events(e.getPackageName(),dateString,"sys",e.getEventType(),e.getTimeStamp(),false));
            else
                eventCls.add(new Events(e.getPackageName(),dateString,"user",e.getEventType(),e.getTimeStamp(),false));


        }
        return eventCls;
    }

    private List<String> getSysPckName(){
        List<String> result=new ArrayList<>();
        List<PackageInfo> packList = context.getPackageManager().getInstalledPackages(0);
        for (int i=0; i < packList.size(); i++)
        {
            PackageInfo packInfo = packList.get(i);
            if (  (packInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0)
            {
                result.add(packInfo.packageName);
            }
        }
        return result;
    }


    List<UsageStats> getUsageList(int dayPast){
        UsageStatsManager usm= getUsageStatusManager();
        Calendar calendar= Calendar.getInstance();
        long endTime=calendar.getTimeInMillis();
        calendar.add(Calendar.DAY_OF_WEEK,-dayPast);
        long startTime=calendar.getTimeInMillis();
        int interval=UsageStatsManager.INTERVAL_DAILY;

        return usm.queryUsageStats(interval,startTime,endTime);
    }

    @SuppressLint("SimpleDateFormat")
    ArrayList<Status> convertUsageStatus(List<UsageStats> usageStats, int pas) {
        ArrayList<Status> statuses = new ArrayList<>();
        List<String> sysPck = getSysPckName();
        String dateString = new SimpleDateFormat("dd/MM/yyyy").format((double) Calendar.getInstance().getTimeInMillis());
        UsageStats stats;
        for (int i = usageStats.size() - 1; i >= 0; i--) {
            stats = usageStats.get(i);
            if (sysPck.contains(stats.getPackageName()))
                statuses.add(new Status(stats.getPackageName(), "sys",dateString, Calendar.getInstance().getTimeInMillis(), stats.getTotalTimeInForeground(),pas, false));
            else
                statuses.add(new Status(stats.getPackageName(), "user",dateString, Calendar.getInstance().getTimeInMillis(), stats.getTotalTimeInForeground(),pas, false));

        }

        return statuses;
    }

//    private String pasDayConDate(String date,int dayPas){
//        String result="";
//
//        int day= Integer.parseInt(date.split("/")[0])-dayPas;
//        result = day + date.substring(2);
//        return result;
//
//    }

    @SuppressWarnings("ResourceType")
    private UsageStatsManager getUsageStatusManager(){
        return (UsageStatsManager) context.getSystemService("usagestats");
    }
}
