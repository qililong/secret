package cn.ucai.secret.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import cn.ucai.secret.R;

public class Register2Activity extends Activity {
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        initView();
        setListener();
    }

    private void setListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.ivRegister2_back);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
