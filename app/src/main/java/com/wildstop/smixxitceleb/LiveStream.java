package com.wildstop.smixxitceleb;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.cameraview.CameraView;

public class LiveStream extends AppCompatActivity {
    CameraView mCameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stream);
        mCameraView=(CameraView)findViewById(R.id.camera);
        final ImageView imageViewLady=(ImageView)findViewById(R.id.imageview_lady);
        ImageView imageGrid=(ImageView)findViewById(R.id.image_grid);

        imageGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog.Builder dialog = new ProgressDialog.Builder(LiveStream.this);
                dialog.setMessage("Confirm Change Of User");
                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       imageViewLady.setImageResource(R.mipmap.girl_smiling);
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.setCancelable(false);
                dialog.show();
            }
        });

        imageGrid.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ProgressDialog.Builder dialog = new ProgressDialog.Builder(LiveStream.this);
                dialog.setMessage("Gift This User 20 Points");
                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                        Toast.makeText(LiveStream.this, "You've Gifted 20 Points", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.setCancelable(false);
                dialog.show();
                return false;
            }
        });

        imageViewLady.setOnClickListener(new View.OnClickListener() {
            ProgressDialog.Builder dialog2 = new ProgressDialog.Builder(LiveStream.this);
            @Override
            public void onClick(View v) {
                ProgressDialog.Builder dialog = new ProgressDialog.Builder(LiveStream.this);
                dialog.setMessage("Gift This User With 20 Points");
                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {
                     new CountDownTimer(3000,1000){

                         @Override
                         public void onTick(long millisUntilFinished) {

                             dialog.dismiss();
                             dialog2.setMessage("You've gifted 20 Points");
                             dialog2.show();
                         }

                         @Override
                         public void onFinish() {
                            dialog2.setCancelable(true);

                         }
                     }.start();
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.setCancelable(false);
                dialog.show();
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        mCameraView.start();
    }

    @Override
    protected void onPause() {
        mCameraView.stop();
        super.onPause();
    }
}
