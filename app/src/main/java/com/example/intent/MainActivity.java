package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intent.utils.AppConstants;

public class MainActivity extends AppCompatActivity {
    private EditText mEd_name, mEd_password, mEd_email, mEd_gender;
    private Button mBtn_send;
    private RadioGroup mGenderChoose;
    private TextView mTextError;
    private RadioButton mMale, mFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContent();
        mGenderChoose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.m){
                    mTextError.setError(null);
                    /*
                    Toast.makeText(getApplicationContext(), "choice: m",

                            Toast.LENGTH_SHORT).show();*/
                }
                else if(checkedId == R.id.f){
                    mTextError.setError(null);
                    /*
                    Toast.makeText(getApplicationContext(), "choice: f",
                            Toast.LENGTH_SHORT).show();
                            */
                }
            }
        });

        mBtn_send.setOnClickListener(v->{
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(mEd_email.getText().toString()).matches() && (getmGenderChoose()!="") ) {
                Intent mIntent = new Intent(MainActivity.this,ShareActivity.class);
                //String[] mUserInfo = {mEd_name.getText().toString(), mEd_password.getText().toString(), mEd_email.getText().toString(), mEd_gender.getText().toString()};
                String[] mUserInfo = {mEd_name.getText().toString(), mEd_password.getText().toString(), mEd_email.getText().toString(), getmGenderChoose()};
                mIntent.putExtra(AppConstants.TEXT_KEY,mUserInfo);
                startActivity(mIntent);
            }
            else{
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mEd_email.getText().toString()).matches()){
                    mEd_email.setError("invalid email");
                }
                if (getmGenderChoose()==""){
                    mTextError.setError("invalid");

                }
                else {
                    mTextError.setError(null);
                }

            }

        });

    }
    public String getmGenderChoose(){
        int selectedId = mGenderChoose.getCheckedRadioButtonId();

        // find which radioButton is checked by id
        if(selectedId == mMale.getId()) {
            return mFemale.getText().toString();
        } else if(selectedId == mFemale.getId()) {
            return mFemale.getText().toString();

        } else {
            return "";
        }
    }


    public void setContent(){
        mEd_name = findViewById(R.id.user_name);
        mEd_password = findViewById(R.id.user_password);
        mEd_email = findViewById(R.id.user_email);
       // mEd_gender = findViewById(R.id.user_gender);
        mBtn_send = findViewById(R.id.btn_send);

        mGenderChoose = findViewById(R.id.user_gender);
        mMale = findViewById(R.id.m);
        mFemale = findViewById(R.id.f);
        mTextError = findViewById(R.id.tv_error);

    }
}