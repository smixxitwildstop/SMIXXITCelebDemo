package com.wildstop.smixxitceleb;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {

    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CircularImageView jb=(CircularImageView)findViewById(R.id.justinbieber_img);
        CircularImageView chance=(CircularImageView)findViewById(R.id.chance_img);
        CircularImageView bonjovi=(CircularImageView)findViewById(R.id.jovi_img);
        CircularImageView chrisbrown=(CircularImageView)findViewById(R.id.chrisbrown_img);
        CircularImageView coldplay=(CircularImageView)findViewById(R.id.coldplay_img);
        CircularImageView kanye=(CircularImageView)findViewById(R.id.kanye_west);
        CircularImageView kimkardashian=(CircularImageView)findViewById(R.id.kim_kardashian_img);
        CircularImageView kloe=(CircularImageView)findViewById(R.id.kloe_kardashian);
        CircularImageView gaga=(CircularImageView)findViewById(R.id.lady_gaga_img);
        CircularImageView metro=(CircularImageView)findViewById(R.id.metro_boomin);
        CircularImageView nickiminaj=(CircularImageView)findViewById(R.id.nicki_img);
        CircularImageView raeshremmurd=(CircularImageView)findViewById(R.id.rae_shremmurd_img);
        CircularImageView tyer=(CircularImageView)findViewById(R.id.tyler_img);
        CircularImageView usher=(CircularImageView)findViewById(R.id.usher_img);
        ImageView imageviewone=(ImageView)findViewById(R.id.imageview_list_one);
        ImageView imageviewtwo=(ImageView)findViewById(R.id.imageview_list_two);


        Picasso.with(getApplicationContext()).load("https://yt3.ggpht.com/-VA1VJBph20Q/AAAAAAAAAAI/AAAAAAAAAAA/WJxOBPTsGt8/s900-c-k-no-mo-rj-c0xffffff/photo.jpg").into(jb);
        Picasso.with(getApplicationContext()).load("https://s-media-cache-ak0.pinimg.com/originals/71/4f/d7/714fd784c2453c2195a663234f74b81a.png").into(chance);
        Picasso.with(getApplicationContext()).load("http://images2.wikia.nocookie.net/__cb20100807050131/doblaje/es/images/7/73/Jon_Bon_Jovi.jpg").into(bonjovi);
        Picasso.with(getApplicationContext()).load("http://a.abcnews.com/images/Entertainment/GTY_chris_brown_3_jt_160102_12x5_1600.jpg").into(chrisbrown);
        Picasso.with(getApplicationContext()).load("http://img.aceshowbiz.com/images/photo/coldplay.jpg").into(coldplay);
        Picasso.with(getApplicationContext()).load("http://cdn3.pitchfork.com/news/63330/9b813a8d.jpg").into(kanye);
        Picasso.with(getApplicationContext()).load("https://peopledotcom.files.wordpress.com/2015/06/kim-kardashian-01-600x800.jpg").into(kimkardashian);
        Picasso.with(getApplicationContext()).load("https://images-na.ssl-images-amazon.com/images/M/MV5BMTI3NDM0NzM3N15BMl5BanBnXkFtZTcwNzAyNjI5MQ@@._V1_UY317_CR4,0,214,317_AL_.jpg").into(kloe);
        Picasso.with(getApplicationContext()).load("http://cdn-img.instyle.com/sites/default/files/styles/684xflex/public/images/2016/02/020316-lady-gaga.jpg").into(gaga);
        Picasso.with(getApplicationContext()).load("http://origin-blog-us.napster.com/wp-content/uploads/2016/05/MetroBoomin-1.jpg").into(metro);
        Picasso.with(getApplicationContext()).load("http://www.billboard.com/files/styles/article_main_image/public/media/nicki-minaj-press-2014-650.jpg").into(nickiminaj);
        Picasso.with(getApplicationContext()).load("http://cache.umusic.com/_sites/_halo/raesremmurd/images/share.jpg").into(raeshremmurd);
        Picasso.with(getApplicationContext()).load("http://www.busyworksbeats.com/wp-content/uploads/2015/03/tyler-the-creator-tamale-1.jpg").into(tyer);
        Picasso.with(getApplicationContext()).load("http://vatalent.com/uploads/sitePics/usher_416x416.jpg").into(usher);

        jb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog.Builder dialog = new ProgressDialog.Builder(Profile.this);
                dialog.setTitle("Confirm");
                dialog.setMessage("Confirm That You Want To Send Justin Bieber A Text");
                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Profile.this,ChatScreen.class);
                        startActivity(intent);
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


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<String> permissionsNeeded = new ArrayList<String>();

            final List<String> permissionsList = new ArrayList<String>();
            if (!addPermission(permissionsList, android.Manifest.permission.ACCESS_FINE_LOCATION))
                permissionsNeeded.add("GPS");
            if (!addPermission(permissionsList, android.Manifest.permission.WRITE_EXTERNAL_STORAGE))
                permissionsNeeded.add("Write to storage");
            if (!addPermission(permissionsList, android.Manifest.permission.CAMERA))
                permissionsNeeded.add("Camera");
            if (!addPermission(permissionsList, android.Manifest.permission.RECORD_AUDIO))
                permissionsNeeded.add("Audio");
            if (!addPermission(permissionsList, android.Manifest.permission.ACCESS_FINE_LOCATION))
                permissionsNeeded.add("Location");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                            REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
                }
            }
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Begin SMIXXIT LIVESTREAM", Snackbar.LENGTH_LONG)
                        .setAction("YES", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Profile.this,LiveStream.class);
                                startActivity(intent);
                            }
                        }).show();
            }
        });
        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(Profile.this,Acknowledgments.class);
                startActivity(intent);
                return false;
            }
        });
    }
    private boolean addPermission(List<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!shouldShowRequestPermissionRationale(permission))
                return false;
        }
        return true;
    }

}
