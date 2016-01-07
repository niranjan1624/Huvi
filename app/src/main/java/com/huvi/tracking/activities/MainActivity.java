package com.huvi.tracking.activities;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.huvi.tracking.R;
import com.huvi.tracking.model.SMS;
import com.tuenti.smsradar.Sms;
import com.tuenti.smsradar.SmsListener;
import com.tuenti.smsradar.SmsRadar;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    TextView helloWorld;
    static String messageStr = "Initializing...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloWorld = (TextView) findViewById(R.id.test);
        helloWorld.setText(messageStr);

        createDirectoriesIfNotExist();
        initializeSmsRadarService();
    }

    private void initializeSmsRadarService() {
        Log.d("DEBUG", "initialized sms radar service");
        SmsRadar.initializeSmsRadarService(this, new SmsListener() {
            @Override
            public void onSmsSent(Sms sms) {
                Log.d("DEBUG_SENT", sms.getMsg());
                messageStr = messageStr + "\n\n" + sms.getAddress() + " : OUTGOING \n" + sms.getMsg();
                helloWorld.setText(messageStr);
                SMS sms1 = new SMS(sms);
                sms1.save();
            }

            @Override
            public void onSmsReceived(Sms sms) {
                Log.d("DEBUG_INCOME", sms.getMsg());
                messageStr = messageStr + "\n\n" + sms.getAddress() + " : INCOMING \n" + sms.getMsg();
                helloWorld.setText(messageStr);
                SMS sms1 = new SMS(sms);
                sms1.save();
            }
        });
    }

    public void createDirectoriesIfNotExist() {
        File sub = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "Huvi");
        if (!sub.exists())
            sub.mkdirs();
        else {
            sub = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Huvi", "Audio");
            if (!sub.exists())
                sub.mkdirs();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
