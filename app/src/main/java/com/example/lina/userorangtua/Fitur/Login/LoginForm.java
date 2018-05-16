package com.example.lina.userorangtua.Fitur.Login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Fitur.Menu.ButtomNavigation;
import com.example.lina.userorangtua.Model.Login.ModelResultLogin;
import com.example.lina.userorangtua.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginForm extends AppCompatActivity {

    private ModelResultLogin modelResultLogin;
    private EditText etUsername,etPassword;
    private SessionManager sessionManager;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        SharedPreferences sharedPreferences = getSharedPreferences("bsmart", MODE_PRIVATE);
        final SharedPreferences.Editor edit =sharedPreferences.edit();
        edit.clear();
        edit.apply();

        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        Button bt = (Button) findViewById(R.id.bt);

//        sessionManager = new SessionManager(getApplicationContext());
//        if(sessionManager.isLogin()){
//            Intent intent = new Intent(LoginForm.this, ButtomNavigation.class);
//            startActivity(intent);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            finish();
//        }

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService.services_post.login(etUsername.getText().toString(),etPassword.getText().toString()).enqueue(new Callback<ModelResultLogin>() {
                    @Override
                    public void onResponse(Call<ModelResultLogin> call, Response<ModelResultLogin> response) {
                        modelResultLogin = response.body();
//                        if(modelResultLogin != null) {
//                            sessionManager.setUid(modelResultLogin.getResult().getId());
//                            sessionManager.setLogin(true);
//                            sessionManager.setUsername(modelResultLogin.getResult().getUsername());

                            edit.putString("username", modelResultLogin.getResult().getUsername());
                            edit.putInt("idorangtua", modelResultLogin.getResult().getIdorangtua());
                            edit.commit();

                            //SharedPreferences sharedPreferences = getSharedPreferences("bsmart", MODE_PRIVATE);
                            //SharedPreferences.Editor edit =sharedPreferences.edit();


                            Log.d("username", modelResultLogin.getResult().getUsername());
                            Log.d("email", modelResultLogin.getResult().getEmail());
                            Log.d("idorangtua", String.valueOf(modelResultLogin.getResult().getIdorangtua()));


                            Intent intent = new Intent(LoginForm.this, ButtomNavigation.class);
                            startActivity(intent);
//                        }
//                        else{
//                            Toast.makeText(LoginForm.this, "Akun belum terdaftar !", Toast.LENGTH_SHORT).show();
//                        }
                    }

                    @Override
                    public void onFailure(Call<ModelResultLogin> call, Throwable t) {
                        Toast.makeText(LoginForm.this, "Akun belum terdaftar !", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
