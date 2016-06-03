package cn.ucai.secret.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

import cn.ucai.secret.R;
import cn.ucai.secret.bean.City;
import cn.ucai.secret.bean.Province;


public class Login1Activity extends Activity {
    ArrayList<Province> arrayList = new ArrayList();
    City[] city;
    Province province;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        parseData();
    }

    private void parseData() {
        String res = null;
        InputStream in = getResources().openRawResource(R.raw.citys);
        try {
            int length = in.available();
            byte[] buffer = new byte[length];
            in.read(buffer);
            res = EncodingUtils.getString(buffer, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            JSONArray json = new JSONArray(res);
            for (int i = 0; i < json.length(); i++) {
                Log.e("main", "json" + json.length());
                JSONObject jsonArray = new JSONObject(json.get(i).toString());
                JSONArray citys = jsonArray.getJSONArray("citys");
                city = new City[citys.length()];
                for (int t = 0; t < citys.length(); t++) {
                    Log.e("main", "citys" + citys.length());
                    JSONObject js = new JSONObject(citys.get(t).toString());
                    City city1 = new City(js.getString("id"), js.getString("city"));
                    city[t] = city1;
                }
                province = new Province(jsonArray.getString("name"), city);
                arrayList.add(province);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    class myHolder1 extends RecyclerView.ViewHolder {
        TextView tv1;
        ImageView iv1;

        public myHolder1(View itemView) {
            super(itemView);
            tv1 = (TextView) findViewById(R.id.tvCityName);
            iv1 = (ImageView) findViewById(R.id.ivOk);
        }
    }
}
