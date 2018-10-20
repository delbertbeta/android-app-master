package com.lmmnb.guangzhouculturehelper.app.view.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.Fragment.First_page;
import com.lmmnb.guangzhouculturehelper.app.view.MainActivity;

import java.io.File;
import java.io.IOException;
import java.util.zip.CheckedOutputStream;

/**
 * Created by Hawk Duke on 2018/3/29.
 */

public class RecordButton extends RelativeLayout {

    private Context context;
    private android.app.Activity activity;
    private Ripple ripple;
    private ImageView img;
    //长按说话按钮是否被长按标识
    private boolean isLongClicked=false;
    // 录音类
    private MediaRecorder mediaRecorder;
    // 以文件的形式保存
    private File recordFile;
    // 文件读写权限
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };


    public RecordButton(Context context) {
        super(context);
        this.context = context;
        this.activity = (Activity)context;
    }

    public RecordButton(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        this.context = context;
        this.activity = (Activity)context;
        View view = LayoutInflater.from(context).inflate(R.layout.recordbtn,this);
        init(context);
    }

    private void init(final Context context)
    {
        ripple = (Ripple)findViewById(R.id.ripple);
        img = (ImageView)findViewById(R.id.centerImage);
        recordFile = new File("/mnt/sdcard", "test.amr"); // 文件暂存路径
        img.setOnTouchListener(new PressToSpeakListen());// 判断是否是长按事件
        img.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                isLongClicked = true;
                First_page.et1.et2.setHint("说吧，我在听呢~");
                // 是长按事件，开始录音
                try {
                    //录音开启操作在线程中处理。防止在首次使用录音功能时，系统弹录音权限框，而用户长时间不处理造成ANR
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //开始录音
                            //Toast.makeText(MainActivity.this,"开始录音",Toast.LENGTH_SHORT).show();
                            startRecording();
                        }
                    }).start();
                } catch (Exception e) {
                    e.printStackTrace();
                    //取消录音
                    //cancelRecord();
                    stopRecording();
                    Toast.makeText(context,"录音失败，请重试",Toast.LENGTH_SHORT).show();
                    return false;
                }
                return false;
            }
        });


    }

    class PressToSpeakListen implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    ripple.startRippleAnimation();
                    if (!Environment.getExternalStorageState().equals(
                            android.os.Environment.MEDIA_MOUNTED)) {
                        return false;
                    }

                    return false;
                case MotionEvent.ACTION_UP:
                    ripple.stopRippleAnimation();  //动画效果停止
                    //手指抬起后判断语言转换的情景来设定hint
                    // true 普通话=>粤语
                    // false 粤语语音=>普通话
                    if(First_page.getText()) {
                        First_page.et1.et2.setHint("在此输入要翻译的文本...");
                    } else {
                        First_page.et1.et2.setHint("请使用语音进行粤语转换");
                    }

                    if (!isLongClicked ) return false;
                    isLongClicked = false;
                    if (event.getY() < 0) {

                    } else {

                    }
                    return false;
                default:
                    //recording_container.setVisibility(View.GONE);
                    return false;
            }
        }
    }
    private void startRecording(){
        mediaRecorder = new MediaRecorder();
        if (!Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED))
        {
            Toast.makeText(this.context, "SD卡不存在，请插入SD卡！",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        //⑧申请录制音频的动态权限
        if(ContextCompat.checkSelfPermission(this.context, android.Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this.activity,new String[]{
                    android.Manifest.permission.RECORD_AUDIO},1);
        }else{
            //申请读写sd卡的动态权限
            try {
                //检测是否有写的权限
                int permission = ActivityCompat.checkSelfPermission(this.context,
                        "android.permission.WRITE_EXTERNAL_STORAGE");
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    // 没有写的权限，去申请写的权限，会弹出对话框
                    ActivityCompat.requestPermissions(this.activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder
                    .OutputFormat.AMR_NB);
            mediaRecorder.setAudioEncoder(MediaRecorder
                    .AudioEncoder.AMR_NB);
            mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
            // 判断，若当前文件已存在，则删除
            if (recordFile.exists()) {
                Log.d("Tag","before delete--------------"+recordFile.getTotalSpace()+"--------------");
                deleteFile();
                Log.d("Tag","after delete--------------"+recordFile.getTotalSpace()+"--------------");
                Log.d("Tag","----------------------"+recordFile.getAbsolutePath()+"-----------------------------");
            }
            try {
                // 准备好开始录音
                mediaRecorder.prepare();
                mediaRecorder.start();
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    private void stopRecording(){
        if (recordFile != null) {
            Log.d("Tag","--------------"+recordFile.getTotalSpace()+"--------------");
            mediaRecorder.reset();
            Log.d("Tag","--------------"+recordFile.getTotalSpace()+"--------------");
            mediaRecorder.release();
        }
        else{
            Log.d("Tag","--------null pointer--------------");
        }

    }

    private boolean deleteFile(){
        // 防止录音文件删除不干净
        boolean result = false;
        if(recordFile.isDirectory()){
            File[] files = recordFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()){
                    File file = new File(files[i].getPath());
                    Log.d("photoPath -->> ", file.getPath());
                    file.delete();
                }
            }
            recordFile.delete();
        }
        return result;

    }
}
