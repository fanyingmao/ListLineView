package com.example.fanyingmao.test;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv_test;
    ArrayList<TestBean> listTestBean;
    private TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_test = (ListView)findViewById(R.id.lv_test);
        listTestBean = new ArrayList<>();

        adapter = new TestAdapter(listTestBean);
        lv_test.setAdapter(adapter);
        for (int i = 0; i < 300; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                list.add(j);
            }

            TestBean mTestBean = new TestBean();
            mTestBean.setList(list);
            int tem = MyMath.getRandInt(10)-4;
            if(tem < 0){
                mTestBean.setMid(true);
            }
            else {
                mTestBean.setMid(false);
                mTestBean.setSelectN(tem);
            }
            listTestBean.add(mTestBean);
        }


        initMid();

        adapter.notifyDataSetChanged();
        lv_test.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        },500);
    }

    private void changeList(ArrayList<Integer> list, int i, int j) {
        int t = list.get(i);
        list.remove(i);
        list.add(j, t);
    }

    private void initMid(){
        int j = 0;
        int tem = 0;
        for (int i = 0; i < listTestBean.size(); i++) {
            if(listTestBean.get(i).isMid()){
                listTestBean.get(i).setUpNum(j++);
                listTestBean.get(i).setUpSelect(tem);
            }
            else{
                listTestBean.get(i).setUpNum(j);
                listTestBean.get(i).setUpSelect(tem);
                tem = listTestBean.get(i).getSelectN();
                j = 0;
            }
        }
        j = 0;
        tem = 0;
        for (int i = listTestBean.size() - 1; i >= 0 ; i--) {
            if(listTestBean.get(i).isMid()){
                listTestBean.get(i).setDownNum(j++);
                listTestBean.get(i).setDownSelect(tem);
            }
            else{
                listTestBean.get(i).setDownNum(j);
                listTestBean.get(i).setDownSelect(tem);
                tem = listTestBean.get(i).getSelectN();
                j = 0;
            }
        }
    }
}
