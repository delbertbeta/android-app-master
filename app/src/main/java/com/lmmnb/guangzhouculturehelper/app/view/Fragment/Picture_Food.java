package com.lmmnb.guangzhouculturehelper.app.view.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.io.File;
import java.io.FileNotFoundException;
import com.lmmnb.guangzhouculturehelper.R;

import java.io.File;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;


/**
 * Created by 76952 on 2018/9/29.
 */

public class Picture_Food extends Fragment implements View.OnClickListener{
    private View rootView;
    private static final int TAKE_PHOTO=1;
    private ImageView picture;
    private Uri imageUri;
    private ImageButton takePhoto;
    private Button camera_return;
    File outputImage;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.picture_food,container,false);
        initView();
        return rootView;
    }
    public void initView(){
        takePhoto=(ImageButton)rootView.findViewById(R.id.camera);
        picture=(ImageView)rootView.findViewById(R.id.picture);
        takePhoto.setOnClickListener(this);
        camera_return = (Button) rootView.findViewById(R.id.camear_return);
        camera_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.camera:
                takePicture();
                break;
            default:
                break;
        }
    }

    private void takePicture(){
        outputImage=new File(getActivity().getExternalCacheDir(),"output_image.jpg");
        //outputImage  /storage/emulated/0/Android/data/com.example.a76952.food_share_test/cache/output_image.jpg
        try{
            if(outputImage.exists()){
                // exists
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
            imageUri=Uri.fromFile(outputImage);
        }
        // imageUri file:///storage/emulated/0/Android/data/com.example.a76952.food_share_test/cache/output_image.jpg
        Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(intent,TAKE_PHOTO);

    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case TAKE_PHOTO:
                if(resultCode==RESULT_OK){
                    Log.d("requestCode","==RESULT_OK");
                    try{
                        Log.d("try","come in try");
                        Bitmap bitmap= BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(imageUri));
                        if(bitmap==null)
                            Log.d("bitmap","==null");
                        picture.setImageBitmap(bitmap);

                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                }
                else{
                    Log.d("requestCode","==RESULT_Failed");
                }
                break;
            default:
                Log.d("requestCode","!=???");
                break;
        }
    }
}
