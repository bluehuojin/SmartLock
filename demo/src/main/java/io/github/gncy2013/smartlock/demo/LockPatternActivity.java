package io.github.gncy2013.smartlock.demo;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;

import java.util.List;


@SuppressWarnings("NullableProblems")
public class LockPatternActivity extends Activity {
    //NumView nmView;
    //private static final boolean DBG = true;
    //private static final String TAG = "MainActivity";
//    public static final int MSG_LAUNCH_HOME = 0;
//    public static final int MSG_LAUNCH_DIAL = 1;
//    public static final int MSG_LAUNCH_SMS = 2;
//    public static final int MSG_LAUNCH_CAMERA = 3;
    //private LockView mLockView;
    public static TimeView mTimeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_lock);

        final LockPatternUtils mLockPatternUtils = new LockPatternUtils(this);
        LockPatternView mLockPatternView = (LockPatternView) findViewById(R.id.LockView);
        mLockPatternView.setOnPatternListener(new LockPatternView.OnPatternListener() {
            public void onPatternStart() {
            }
            public void onPatternDetected(List<LockPatternView.Cell> pattern) {
                /*if (opFLag) {
                    int result = mLockPatternUtils.checkPattern(pattern);
                    if (result != 1) {
                        if (result == 0) {
                            mLockPatternUtils.setDisplayMode(LockPatternView.DisplayMode.Wrong);
                            Toast.makeText(MainActivity.this, "ÃÜÂë´íÎó", Toast.LENGTH_LONG)
                                    .show();
                        } else {
                            mLockPatternUtils.clearPattern();
                            Toast.makeText(MainActivity.this, "ÇëÉèÖÃÃÜÂë", Toast.LENGTH_LONG)
                                    .show();
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "ÃÜÂëÕýÈ·", Toast.LENGTH_LONG)
                                .show();
                    }
                } else {
                    lockPatternUtils.saveLockPattern(pattern);
                    Toast.makeText(MainActivity.this, "ÃÜÂëÒÑ¾­ÉèÖÃ", Toast.LENGTH_LONG)
                            .show();
                    mLockPatternView.clearPattern();
                }*/
            }
            public void onPatternCleared() {
            }
            public void onPatternCellAdded(List<LockPatternView.Cell> pattern) {
            }
        });

            //initViews();

            mTimeView=new

            TimeView(this,this.getApplicationContext()

            );

            //mLockView.setMainHandler(mHandler);
            //nmView = (NumView) findViewById(R.id.NumView);
            //nmView.setAnimationType("loop");

            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
            //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT)
            {
                //透明状态栏 透明导航栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        }

                //屏蔽BACK, VOL UP/DOWN
        @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        return disableKeycode(keyCode, event);
    }

    private boolean disableKeycode(int keyCode, KeyEvent event)
    {
        int key = event.getKeyCode();
        switch (key)
        {
            case KeyEvent.KEYCODE_HOME:
            case KeyEvent.KEYCODE_BACK:
            case KeyEvent.KEYCODE_VOLUME_UP:
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    /*public void initViews() {
        mLockView = (LockView) findViewById(R.id.LockView);
    }*/
}
