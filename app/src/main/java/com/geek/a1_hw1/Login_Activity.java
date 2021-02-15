package com.geek.a1_hw1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {
    Button btn;
    EditText editText1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        btn = findViewById(R.id.button);
        editText1 = findViewById(R.id.emailText);
        editText2= findViewById(R.id.password);
        editText2.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        final int[] countTExt = {0,0};
        int btnColor = getResources().getColor(R.color.orange);
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                  countTExt[1] += count;
            }
            @Override
            public void afterTextChanged(Editable s) { }});
        final String[] str = {""};
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 1 )countTExt[0] += count;
                if (count == 0 )countTExt[0] -= 1;

                if (countTExt[0] > 5 && countTExt[1] > 5 ){  btn.setBackgroundColor(btnColor);}
                if (countTExt[0] < 5 ){ btn.setBackgroundColor(getResources().getColor(R.color.gray)); }

            }
            @Override
            public void afterTextChanged(Editable s) {
            }});

    }

    public void sendMessage(View view){
        EditText editText = findViewById(R.id.emailText);
        Toast toast = Toast.makeText(this,"WELCOME "+editText.getText(),Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,160);
        toast.show();
    }
    public void forgotPassword(View view){

    }


}