package bharat.com.stackoverflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import bharat.com.stackoverflow.R;
import bharat.com.stackoverflow.ResObj;
import bharat.com.stackoverflow.ApiUtils;
import bharat.com.stackoverflow.UserService;
//import com.jackrutorial.androidloginrestfulwebserviceexample.model.ResObj;
//import com.jackrutorial.androidloginrestfulwebserviceexample.remote.ApiUtils;
//import com.jackrutorial.androidloginrestfulwebserviceexample.remote.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginAcitivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //edtUsername = (EditText) findViewById(R.id.edtUsername);
        //edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.loginButon);
        userService = ApiUtils.getUserService();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String client_id = "14864";
                String Scope = "no_expiry";
                String redirect_uri= "content://bharat.com.stackoverflow.Usernterest";

                //validate form
                  //do login
                    doLogin(client_id, Scope, redirect_uri);
                }

        });

    }

    private boolean validateLogin(String username, String password){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void doLogin(final String client_id,final String Scope, final String redirect_uri){
        Call call = userService.login(client_id,Scope,redirect_uri);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    ResObj resObj = (ResObj) response.body();
                    if(resObj.getMessage().contains("&")){
                        //login start main activity
                        Intent intent = new Intent(LoginAcitivity.this, UserInterestActivty.class);
                        //intent.putExtra("username", username);
                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginAcitivity.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginAcitivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(LoginAcitivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}