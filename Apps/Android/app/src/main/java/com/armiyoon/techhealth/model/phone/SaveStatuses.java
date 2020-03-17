package com.armiyoon.techhealth.model.phone;

import android.content.Context;

import com.armiyoon.techhealth.model.database.MyDatabase;
import com.armiyoon.techhealth.model.database.model.Events;
import com.armiyoon.techhealth.model.database.model.Status;

import java.util.ArrayList;
import java.util.List;

public class SaveStatuses {

    private MyDatabase database;
    private GetStatus status;

    public SaveStatuses(Context context){
        database=new MyDatabase(context);
        status=new GetStatus(context);
        set();
    }

    private void set(){

        ArrayList<Status> statuses;
        if(database.getAllStatus().size()>50)
            statuses=status.convertUsageStatus(status.getUsageList(1),1);
        else
            statuses=status.convertUsageStatus(status.getUsageList(6),6);

        for (Status status : statuses) {
            if(status!=null)
                database.addStatus(status);
        }

        List<Events> events=status.convertEventStatus(status.getStatus(1));
        for (Events event : events){
            if(event!=null)
                database.addEvents(event);
        }
    }


}
