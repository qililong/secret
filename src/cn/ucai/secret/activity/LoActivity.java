package cn.ucai.secret.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.ucai.secret.R;

public class LoActivity extends Activity {
    Button mRegist;
    TextView mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lo);
        initView();
        setListener();
    }

    private void setListener() {
        mRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoActivity.this,Login1Activity.class));
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoActivity.this,LoginActivity.class));
            }
        });
    }

    private void initView() {
        mRegist = (Button) findViewById(R.id.btnLogin);
        mLogin = (TextView) findViewById(R.id.tvs);
    }
}
