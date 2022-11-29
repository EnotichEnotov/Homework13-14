package com.example.homework13_14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homework13_14.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent;
        Log.v("click","started");
        switch (view.getId()) {
            case R.id.button:
                if( binding.password.getText().toString().equals("RickAstley") && binding.login.getText().toString().equals("rickroll@gmail.com") && binding.password.getText().length() >= 8 ){
                    /* Немного не понял зачем условие длина больше 8, т.к логин и праоль точно опредлены*/
                    Log.v("entering","enter profile");

                    intent=new Intent(MainActivity.this,AnotherActivity.class);
                    intent.putExtra("LoginText",binding.login.getText().toString());
                    startActivity(intent);
                    finish();
                }
                else{
                    binding.mes.setText("Неверный логин или пароль");
                    Log.v("incorrect","incorrect entering");
                }
        }
    }
}