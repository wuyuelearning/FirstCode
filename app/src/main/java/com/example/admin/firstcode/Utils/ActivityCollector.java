package com.example.admin.firstcode.Utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyue on 2018/5/3.
 *
 *
 */

public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity (Activity activity){
        activities.add(activity);
    }

    public static void remoteActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity :activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }

}
