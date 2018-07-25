package com.example.lina.userorangtua.Fitur.Menu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Fitur.Login.LoginForm;
import com.example.lina.userorangtua.Fitur.Login.Session;
import com.example.lina.userorangtua.Model.EditPassword.EditpasswordResultModel;
import com.example.lina.userorangtua.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPassword extends AppCompatActivity {
    private EditpasswordResultModel editpasswordResultModel;
    private EditText newpass, repeatedpass;
    private Button button;
    private Integer id;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);
        setTitle("Edit Password");

        newpass = (EditText) findViewById(R.id.newpass1);
        repeatedpass = (EditText) findViewById(R.id.repeatedpass1);
        button = (Button) findViewById(R.id.button1);

        session = new Session(EditPassword.this);

        SharedPreferences sharedPreferences = getSharedPreferences("bsmart", MODE_PRIVATE);
        id = sharedPreferences.getInt("iduser",0);
        Log.d("iduser", String.valueOf(sharedPreferences.getInt("iduser",0)));
        Log.d("idorangtua", String.valueOf(sharedPreferences.getInt("idorangtua",0)));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fungsiKlikButton(view);
            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void fungsiKlikButton(View view) {
        ApiService.services_post.editpassword(id, newpass.getText().toString(), repeatedpass.getText().toString()).enqueue(new Callback<EditpasswordResultModel>() {
            @Override
            public void onResponse(Call<EditpasswordResultModel> call, Response<EditpasswordResultModel> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(EditPassword.this, "Berhasil Edit Password !", Toast.LENGTH_SHORT).show();
                    session.setLogin(false, 0, 0);
                    startActivity(new Intent(EditPassword.this, LoginForm.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<EditpasswordResultModel> call, Throwable t) {

            }
        });
    }
}
