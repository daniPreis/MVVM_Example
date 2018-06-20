package com.example.dani.mvvm_example;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.dani.mvvm_example.ModelView.LoginModelView;
import com.example.dani.mvvm_example.View.ILoginView;
import com.example.dani.mvvm_example.View.IViewListener;

public class LoginView extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private EditText editUser;
    private EditText editPass;
    public Button btnLogin;
    public Button btnClear;
    private ProgressBar progressBar;
    private LoginModelView loginModelView;

    private Handler handler = new Handler(Looper.getMainLooper());


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        //find view
        editUser = (EditText) this.findViewById(R.id.et_login_username);
        editPass = (EditText) this.findViewById(R.id.et_login_password);
        btnLogin = (Button) this.findViewById(R.id.btn_login_login);
        btnClear = (Button) this.findViewById(R.id.btn_login_clear);

        loginModelView = new LoginModelView();

        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        loginModelView.addIViewListener(new IViewListener() {
            @Override
            public void onAction(int action) {
                Boolean isLoginSuccess;
                if(action != 0)isLoginSuccess =false;
                else isLoginSuccess = true;
                final Boolean result = isLoginSuccess;

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onLoginResult(result);
                    }
                }, 5000);
            }
        });


    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_login_clear:
                onClearText();
                break;
            case R.id.btn_login_login:
                //  iLoginView.onSetProgressBarVisibility(View.VISIBLE);
                btnLogin.setEnabled(false);
                btnClear.setEnabled(false);
                loginModelView.doLogin(editUser.getText().toString(),
                        editPass.getText().toString());
                break;
        }
    }

    @Override
    public void onClearText() {
        editUser.setText("");
        editPass.setText("");
    }

    public void doLogin(final Boolean newVal) {



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoginResult(newVal);
            }
        }, 5000);
    }

    @Override
    public void onLoginResult(Boolean result) {

        btnLogin.setEnabled(true);
        btnClear.setEnabled(true);
        if (result) {
            Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "Login Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}
