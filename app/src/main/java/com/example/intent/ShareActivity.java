package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.intent.utils.AppConstants;

public class ShareActivity extends AppCompatActivity {
    private TextView mTv_name,mTv_password,mTv_email,mTv_gender;
    private Button mBtn_share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        setContent();

        Intent intent = getIntent();
        String[] mUserInfo = intent.getStringArrayExtra(AppConstants.TEXT_KEY);
        mTv_name.setText(mUserInfo[0]);
        mTv_password.setText(mUserInfo[1]);
        mTv_email.setText(mUserInfo[2]);
        mTv_gender.setText(mUserInfo[3]);

        mBtn_share.setOnClickListener(v->{
            Intent mIntent = new Intent();
            mIntent.setAction(Intent.ACTION_SEND);
            mIntent.setType("text/plain");
            mIntent.putExtra(Intent.EXTRA_TEXT,mUserInfo[0]+ " " + mUserInfo[1]+ " " + mUserInfo[2] + " " + mUserInfo[3]);
            startActivity(mIntent);
        });
    }



    public void setContent(){
        mTv_name = findViewById(R.id.user_name_text);
        mTv_password = findViewById(R.id.user_password_text);
        mTv_email = findViewById(R.id.user_email_text);
        mTv_gender = findViewById(R.id.user_gender_text);

        mBtn_share = findViewById(R.id.btn_share);
    }
}
