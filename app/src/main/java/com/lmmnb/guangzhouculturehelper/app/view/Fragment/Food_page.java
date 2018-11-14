package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lmmnb.guangzhouculturehelper.R;
import com.lmmnb.guangzhouculturehelper.app.view.widget.BottomBar;
import com.lmmnb.guangzhouculturehelper.app.view.widget.MyImgBtn;

import java.io.File;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class Food_page extends Fragment {
    private View rootView;

    private MyImgBtn myImgBtn;
    private static final int TAKE_PHOTO=1;
    private File outputImage= null;
    private Uri imageUri;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.food_page,container,false);

        myImgBtn = (MyImgBtn)rootView.findViewById(R.id.camera);
        myImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });

        BottomBar bottomBar = rootView.findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#ADADAD", "#5C6BB0")
                .addItem(My.class,
                        "推荐",
                        R.drawable.facebefore,
                        R.drawable.faceafter)
                .addItem(Nothing.class,
                        "我的",
                        R.drawable.thumb_before,
                        R.drawable.thumb_after)

                .build();


        return rootView;
    }
    private void takePicture(){
        outputImage=new File(getActivity().getExternalCacheDir(),"output_image.jpg");
        try{
            if(outputImage.exists()){
                outputImage.delete();
            }
            outputImage.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        if(Build.VERSION.SDK_INT>=24){
            imageUri= FileProvider.getUriForFile(getActivity(),
                    "com.lmmnb.guangzhouculturehelper.fileprovider",outputImage);
        }else{
            imageUri= Uri.fromFile(outputImage);
        }
        Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(intent,TAKE_PHOTO);
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case TAKE_PHOTO:
                if(resultCode==RESULT_OK){
                    try{
                        Bitmap bitmap= BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(imageUri));
                        Log.i("size", "width: " + bitmap.getWidth() + " height:" + bitmap.getHeight());
                        if(bitmap==null)
                            Log.d("bitmap","==null");
                        // picture.setImageBitmap(bitmap);
                        // 这里加入拍照成功，调用接口的代码
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    Log.d("requestCode","== RESULT_Failed");
                }
                break;
            default:
                break;
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("destroy","destroy");

    }

}
