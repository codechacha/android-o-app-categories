package com.codechacha.appcategory;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<PackageInfo> result = getPackageManager().getInstalledPackages(0);
        if (result != null) {
            for (PackageInfo info : result) {
                String packageName = info.packageName;
                int categoryNumber = info.applicationInfo.category;
                CharSequence categoryString =
                        ApplicationInfo.getCategoryTitle(this, categoryNumber);

                Log.d(TAG, "App name: " + packageName +", category: " + categoryString);
            }
        }
    }
}
