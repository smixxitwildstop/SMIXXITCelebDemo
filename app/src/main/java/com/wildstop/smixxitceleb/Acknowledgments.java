package com.wildstop.smixxitceleb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by MacbookProOne on 2/20/17.
 */

public class Acknowledgments extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.aknoeledgements);
        super.onCreate(savedInstanceState);
        ImageView imageViewAcknoledgements= (ImageView)findViewById(R.id.imageview_acknowledgements);
        imageViewAcknoledgements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Acknowledgments.this,SendAcknowledgement.class);
                startActivity(intent);
            }
        });
        ImageView imageViewAcknoledgements2= (ImageView)findViewById(R.id.imageview_acknowledgements2);
        imageViewAcknoledgements2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Acknowledgments.this,SendAcknowledgement.class);
                startActivity(intent);
            }
        });
    }
}
