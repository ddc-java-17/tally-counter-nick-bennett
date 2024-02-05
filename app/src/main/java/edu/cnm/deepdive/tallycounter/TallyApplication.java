package edu.cnm.deepdive.tallycounter;

import android.app.Application;
import android.util.Log;

public class TallyApplication extends Application {

  private static final String TAG = TallyApplication.class.getSimpleName();

  @Override
  public void onCreate() {
    super.onCreate();
    // TODO: 2024-02-05 App-level initialization goes here.
    Log.d(TAG, "TallyApplication::onCreate");
  }

}
