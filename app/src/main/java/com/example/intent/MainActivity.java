package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.intent.utils.AppConstants;

public class MainActivity extends AppCompatActivity {
    private EditText mEd_name, mEd_password, mEd_email, mEd_gender;
    private Button mBtn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContent();

        mBtn_send.setOnClickListener(v->{
            Intent mIntent = new Intent(MainActivity.this,ShareActivity.class);
            String[] mUserInfo = {mEd_name.getText().toString(), mEd_password.getText().toString(), mEd_email.getText().toString(), mEd_gender.getText().toString()};
            mIntent.putExtra(AppConstants.TEXT_KEY,mUserInfo);
            startActivity(mIntent);
        });

    }



    public void setContent(){
        mEd_name = findViewById(R.id.user_name);
        mEd_password = findViewById(R.id.user_password);
        mEd_email = findViewById(R.id.user_email);
        mEd_gender = findViewById(R.id.user_gender);
        mBtn_send = findViewById(R.id.btn_send);
    }
}