package com.example.rfc.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   public final static int AC_IMAGE = 1;

    DataBase objDataBase = new DataBase(this);
    EditText etImageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btTakePicture = (Button) findViewById(R.id.btTakePicture);
        Button btSave = (Button) findViewById(R.id.btSave);
        etImageName = (EditText) findViewById(R.id.etImageName);

        btTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(CameraIntent, AC_IMAGE);
            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(objDataBase.InsertPicture(etImageName.getText().toString()))
                    ShowMessage();
            }
        });
    }



    protected void onActivityResult (int request, int result, Intent data ){
        if(request == AC_IMAGE) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            ImageView ivPicture = (ImageView) findViewById(R.id.ivPicture);
            ivPicture.setImageBitmap(image);
        }

    }

    public void ShowMessage(){
        AlertDialog.Builder showMessage = new AlertDialog.Builder(this);
        showMessage.setMessage("Database created!");
        showMessage.setTitle("Alert");
        showMessage.setPositiveButton("OK", null);
        showMessage.setCancelable(true);
        showMessage.create().show();
    }




























     /*   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    /*
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
    }*/
//}

