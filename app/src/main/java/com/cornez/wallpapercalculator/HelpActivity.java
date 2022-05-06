package com.cornez.wallpapercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.view.MenuItem;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;

public class HelpActivity extends AppCompatActivity{
    private TextView tv18;
    private TextView tv17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_layout);
        tv18 = (TextView)findViewById(R.id.textView18);
        tv17 = (TextView)findViewById(R.id.textView17);
    }
    public void gotoInput(View view){
        finish();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            toggleActionBar();
        }
        return true;
    }
    //UHo 5/19/2020 NEW 9l: hide and show action bar
    private void toggleActionBar(){
        ActionBar actionBar = getActionBar();
        if(actionBar != null) {
            if (actionBar.isShowing())
                actionBar.hide();
            else
                actionBar.show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.background_color, menu);
        return true;
    }
    //UHo 5/19/2020 NEW 25l:event handler when meu item is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        View view = this.getWindow().getDecorView();//UHo 5/25/2020 NEW 1l: get screen background
        if(id == R.id.white_background)
        {
            view.setBackgroundResource(R.color.white);
            //UHo 5/25/2020 NEW 2l: change text views color
            tv18.setTextColor(Color.BLACK);
            tv17.setTextColor(Color.BLACK);
            return true;
        }
        else if(id == R.id.sepia_background)
        {
            view.setBackgroundResource(R.color.yellow);
            //UHo 5/25/2020 NEW 2l: change text views color
            tv18.setTextColor(Color.BLACK);
            tv17.setTextColor(Color.BLACK);
            return true;
        }
        else if(id == R.id.dark_background)
        {
            view.setBackgroundResource(R.color.dark);
            //UHo 5/25/2020 NEW 2l: change text views color
            tv18.setTextColor(Color.WHITE);
            tv17.setTextColor(Color.WHITE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
