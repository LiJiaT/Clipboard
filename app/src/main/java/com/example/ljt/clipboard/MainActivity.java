package com.example.ljt.clipboard;

import android.os.Bundle;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    private ClipboardManager myClipboard;
    private ClipData myClip;
    private EditText copyField, pasteField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        copyField = (EditText) findViewById(R.id.editText1);
        pasteField = (EditText) findViewById(R.id.editText2);

    }

    @SuppressLint("NewApi")
    public void copy(View view) {
        String text = copyField.getText().toString();
        myClip = ClipData.newPlainText("text", text);
        myClipboard.setPrimaryClip(myClip);
        Toast.makeText(getApplicationContext(), "Text Copied",
                Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("NewApi")
    public void paste(View view) {
        ClipData abc = myClipboard.getPrimaryClip();
        ClipData.Item item = abc.getItemAt(0);
        String text = item.getText().toString();
        pasteField.setText(text);
        Toast.makeText(getApplicationContext(), "Text Pasted",
                Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
}

