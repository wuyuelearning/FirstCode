package com.example.admin.firstcode.Chapter5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompleteReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context,"Boot Complete2",Toast.LENGTH_LONG).show();
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
