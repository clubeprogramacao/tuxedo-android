package com.fcouceiro.tuxedo;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by franciscocouceiro on 16/03/16.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox mCheckBox;
    private Button mButtonTry;
    private AlertDialog mHomoDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mButtonTry = (Button) findViewById(R.id.buttonTry);
        mButtonTry.setOnClickListener(this);

        ((Button) findViewById(R.id.buttonPick)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(mButtonTry)){
            showHomoDialog(mCheckBox.isChecked());
        }
        else if(v.getId() == R.id.buttonPick){
            Intent intent = new Intent(this, SuitsActivity.class);
            startActivity(intent);
        }
    }

    private void showHomoDialog(boolean isHomo){
        mHomoDialog = new AlertDialog.Builder(this)
                .setTitle("So...")
                .setMessage((isHomo ? "You're" : "You aren't") + " homossexual, huh?")
                .setPositiveButton("That's right!", null)
                .setNegativeButton("No...", null)
                .create();

        //Actually pop'in the thing
        mHomoDialog.show();
    }
}
