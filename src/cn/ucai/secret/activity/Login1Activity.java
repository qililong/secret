package cn.ucai.secret.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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
    RecyclerView rvCity;
    TextView next;
    ImageView back;

    Context context;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        parseData();
        init();
        initView();
        setListener();
    }

    private void setListener() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login1Activity.this, Register2Activity.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void init() {
        context = this;
    }

    private void initView() {
//        rvCity = (RecyclerView) findViewById(R.id.rvCity);
        next = (TextView) findViewById(R.id.tvLogin1Next);
        back = (ImageView) findViewById(R.id.ivLogin1_back);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
//        myAdapter2 mAdapter2 = new myAdapter2(context, arrayList);
//        rvCity.setLayoutManager(linearLayoutManager);
//        rvCity.setAdapter(mAdapter2);
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
                JSONObject jsonArray = new JSONObject(json.get(i).toString());
                JSONArray citys = jsonArray.getJSONArray("citys");
                city = new City[citys.length()];
                for (int t = 0; t < citys.length(); t++) {
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

//    class myHolder1 extends RecyclerView.ViewHolder {
//        TextView tv1;
//        ImageView iv1;
//        public myHolder1(View itemView) {
//            super(itemView);
//            tv1 = (TextView) itemView.findViewById(R.id.tvCityName);
//            iv1 = (ImageView) itemView.findViewById(R.id.ivOk);
//        }
//    }
//
//    class myHolder2 extends RecyclerView.ViewHolder {
//
//        RecyclerView rvCity_item;
//        TextView tvProvince;
//        public myHolder2(View itemView) {
//            super(itemView);
//            rvCity_item = (RecyclerView) itemView.findViewById(R.id.rvCity_item);
//            tvProvince = (TextView) itemView.findViewById(R.id.tvProvince);
//        }
//    }
//
//
//    class myAdaper1 extends RecyclerView.Adapter<myHolder1> {
//        Context context1;
//        ArrayList<City> list;
//
//        public myAdaper1(Context mContext, ArrayList<City> list) {
//            this.context1 = mContext;
//            this.list = list;
//        }
//
//
//        @Override
//
//        public myHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view1 = LayoutInflater.from(context1).inflate(R.layout.login1_item1, parent);
//            parent.removeView(parent);
//            return new myHolder1(view1);
//        }
//
//        @Override
//        public void onBindViewHolder(myHolder1 holder, int position) {
//            City city = list.get(position);
//
//            holder.tv1.setText(city.getCity());
//            holder.iv1.setImageResource(R.drawable.city_check);
//            holder.iv1.setVisibility(View.GONE);
//
//            holder.iv1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    view.setVisibility(View.VISIBLE);
//                }
//            });
//        }
//
//        @Override
//        public int getItemCount() {
//            return list == null?0:list.size();
//        }
//    }
//
//    class myAdapter2 extends RecyclerView.Adapter<myHolder2> {
//        Context context2;
//        ArrayList<Province> list;
//
//        public myAdapter2(Context mContext, ArrayList<Province> list) {
//            this.context2 = mContext;
//            this.list = list;
//        }
//
//        @Override
//        public myHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view2 = LayoutInflater.from(context2).inflate(R.layout.login1_item, parent);
//            parent.removeView(parent);
//            return new myHolder2(view2);
//        }
//
//        @Override
//        public void onBindViewHolder(myHolder2 holder, int position) {
//            Province province = list.get(position);
//            ArrayList<City> cities = new ArrayList<City>();
//            holder.tvProvince.setText(province.getName());
//            City[] citys = province.getCitys();
//            for (int i = 0; i < citys.length; i++) {
//                cities.add(citys[i]);
//            }
//            myAdaper1 myAdaper1 = new myAdaper1(context2, cities);
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context2);
//            holder.rvCity_item.setLayoutManager(linearLayoutManager);
//            holder.rvCity_item.setAdapter(myAdaper1);
//        }
//
//        @Override
//        public int getItemCount() {
//            return list == null?0:list.size();
//        }
//    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
