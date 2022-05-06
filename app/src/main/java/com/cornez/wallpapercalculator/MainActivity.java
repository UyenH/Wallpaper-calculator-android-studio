package com.cornez.wallpapercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.view.MenuItem;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.graphics.Color;//UHo NEW 5/23/2020 1l: we need this to use Color.color name

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //UHo MOD 5/23/2020 26l: UI references for door and windows dimension and all text view
    private EditText room_height;
    private EditText room_length;
    private EditText room_width;
    private EditText door_height;
    private EditText door_width;
    private EditText door_num;
    private EditText window_width;
    private EditText window_height;
    private EditText window_num;
    private TextView display;
    private RadioGroup patter_select;
    private TextView tv;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv10;
    private TextView tv11;
    private TextView tv12;
    private TextView tv13;
    private TextView tv14;
    private TextView tv15;


    //UHo NEW 5/23/2020 1l: object reference for wallpaper
    Wallpaper room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        room = new Wallpaper();
        initialize();
        registerChangedListener();
    }
    //UHo MOD 5/23/2020 28l: obtain reference to UI elements in the main layout include all text views
    private void initialize(){
        room_height = (EditText)findViewById(R.id.wall_height_input);
        room_length = (EditText)findViewById(R.id.room_length_input);
        room_width = (EditText)findViewById(R.id.width2_input);
        door_height = (EditText)findViewById(R.id.door_height_input);
        door_width = (EditText)findViewById(R.id.door_width_input);
        door_num = (EditText)findViewById(R.id.numbersDoorInput);
        window_height = (EditText)findViewById(R.id.window_height_input);
        window_width = (EditText)findViewById(R.id.window_width_input);
        window_num = (EditText)findViewById(R.id.numbersWindowInput);
        patter_select = (RadioGroup)findViewById(R.id.RadioGroup);
        display = (TextView)findViewById(R.id.textView16);
        tv = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);
        tv4 = (TextView)findViewById(R.id.textView4);
        tv5 = (TextView)findViewById(R.id.textView5);
        tv7 = (TextView)findViewById(R.id.textView7);
        tv8 = (TextView)findViewById(R.id.textView8);
        tv9 = (TextView)findViewById(R.id.textView9);
        tv10 = (TextView)findViewById(R.id.textView10);
        tv11 = (TextView)findViewById(R.id.textView11);
        tv12 = (TextView)findViewById(R.id.textView12);
        tv13 = (TextView)findViewById(R.id.textView13);
        tv14 = (TextView)findViewById(R.id.textView14);
        tv15 = (TextView)findViewById(R.id.textView15);
    }
    //UHo NEW 5/23/2020 29l: event handler for compute button
    public void compute_wallpaper(View view){

        double Room_height = Double.valueOf(room_height.getText().toString());
        double Room_length = Double.valueOf(room_length.getText().toString());
        double Room_width  = Double.valueOf(room_width.getText().toString());
        room.setRoom_height(Room_height);
        room.setRoom_width(Room_width);
        room.setRoom_length(Room_length);

        //UHo NEW 5/23/2020 4l: get data for windows dimension
        double win_height = Double.valueOf(window_height.getText().toString());
        double win_width = Double.valueOf(window_width.getText().toString());
        room.setWindow_height(win_height);
        room.setWindow_width(win_width);

        int win_num = Integer.valueOf(window_num.getText().toString());
        room.setWindowNumbers(win_num);

        //UHo NEW 5/23/2020 4l: get data for door dimension
        double Door_height = Double.valueOf(door_height.getText().toString());
        double Door_width = Double.valueOf(door_width.getText().toString());
        room.setDoor_height(Door_height);
        room.setDoor_width(Door_width);

        int Door_num = Integer.valueOf(door_num.getText().toString());
        room.setDoorNumber(Door_num);
        RadioGroup rd = (RadioGroup)findViewById(R.id.RadioGroup);
        //UHo NEW 5/23/2020 5l: if button is not selected tell user to select
        if(rd.getCheckedRadioButtonId() == -1)
        {
            // UHo NEW 5/23/2020 1l: red/yellow text display
            display.setText("Please select a pattern repeat");
            //UHo NEW 5/23/2020 1l: Toast display
            Toast.makeText(getApplicationContext(), "Please select pattern repeat", Toast.LENGTH_SHORT).show();
        }
        //UHo NEW 5/23/2020 5l: if user enter data for room dimension show the wallpaper rolls they need
        else if(room.rolls() > 0 && Room_height > 0 && Room_length > 0 && Room_width >0 ){
            // UHo NEW 5/23/2020 1l: red/yellow text display
            display.setText("You need " + room.rolls() + " wallpaper rolls");
            // UHo NEW 5/23/2020 1l: Toast display
            Toast.makeText(getApplicationContext(), "You need " + room.rolls() + " wallpaper rolls", Toast.LENGTH_SHORT).show();
        }
        //UHo NEW 5/23/2020 5l: if user didn't enter data for room height, length or width tell them to enter
        else if(Room_height == 0.0 || Room_length == 0.0 || Room_width == 0.0)
        {
            display.setText("Enter measurement for room height, length or width");// UHo NEW 5/23/2020 1l: red/yellow text display
            // UHo NEW 5/23/2020 1l: Toast display
            Toast.makeText(getApplicationContext(), "\"Enter measurement for room height, length or width", Toast.LENGTH_SHORT).show();
        }
    }
    //UHo NEW 5/23/2020 2l: event listener when  radio button is selected
    private void registerChangedListener(){
        patter_select.setOnCheckedChangeListener(patternListener1);
    }
    //UHo NEW 5/23/2020 17l: event handler when  radio button is selected
    private OnCheckedChangeListener patternListener1 = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.radioButton:
                    room.setPattern(Wallpaper.patternOne);
                    break;
                case R.id.radioButton2:
                    room.setPattern(Wallpaper.patternTwo);
                    break;
                case R.id.radioButton3:
                    room.setPattern(Wallpaper.patternThree);
                    break;
                case R.id.radioButton4:
                    room.setPattern(Wallpaper.patternFour);
                    break;
            }
        }
    };
    public void gotoHelp(View view){
        Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(helpIntent);
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
    //UHo NEW 5/23/2020 25l: event handler when one of menu item is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        View view = this.getWindow().getDecorView();//UHo 5/25/2020 NEW 1l: get screen background
        if(id == R.id.white_background)
        {
            view.setBackgroundResource(R.color.white);//UHo NEW 5/23/2020 1l: change background color to white
            setTextColor(Color.BLACK);//UHo NEW 5/23/2020 1l: change text color to black
            display.setTextColor(Color.RED);//UHo NEW 5/23/2020 1l: change display rolls text to red
            return true;
        }
        else if(id == R.id.sepia_background)
        {
            view.setBackgroundResource(R.color.yellow);//UHo NEW 5/23/2020 1l: change background color to yellow
            setTextColor(Color.BLACK);//UHo NEW 5/23/2020 1l: change text color to black
            display.setTextColor(Color.RED);//UHo NEW 5/23/2020 1l: change display rolls text to red
            return true;
        }
        else if(id == R.id.dark_background)
        {
            view.setBackgroundResource(R.color.dark);//UHo NEW 5/23/2020 1l: change background color to black
            setTextColor(Color.WHITE);//UHo NEW 5/23/2020 1l: change text color to white
            display.setTextColor(Color.YELLOW);//UHo NEW 5/23/2020 1l: change display rolls text to yellow
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //UHo NEW 5/23/2020 30l: change label color and edit text color
    private void setTextColor(int color){
        tv.setTextColor(color);
        tv2.setTextColor(color);
        tv3.setTextColor(color);
        tv4.setTextColor(color);
        tv5.setTextColor(color);
        tv7.setTextColor(color);
        tv8.setTextColor(color);
        tv9.setTextColor(color);
        tv10.setTextColor(color);
        tv11.setTextColor(color);
        tv12.setTextColor(color);
        tv13.setTextColor(color);
        tv14.setTextColor(color);
        tv15.setTextColor(color);
        room_height.setTextColor(color);
        room_width.setTextColor(color);
        room_length.setTextColor(color);
        door_num.setTextColor(color);
        door_width.setTextColor(color);
        door_height.setTextColor(color);
        window_num.setTextColor(color);
        window_width.setTextColor(color);
        window_height.setTextColor(color);
    }
}
