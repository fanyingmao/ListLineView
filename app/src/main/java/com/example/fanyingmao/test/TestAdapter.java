package com.example.fanyingmao.test;

import android.graphics.Point;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by fanyingmao on 2017/car_3/car_8.
 */

/**
 * Created by fanyingmao on 2017/car_3/car_8.
 */

public class TestAdapter extends BaseAdapter{
    ArrayList<TestBean> listTestBean;
    ArrayList<Float> listPoint = new ArrayList<>();
    public TestAdapter(ArrayList<TestBean> listTestBean) {
        this.listTestBean = listTestBean;
    }

    @Override
    public int getCount() {
        return listTestBean.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.item_test, null);
            holder.tv_0 = (TextView)view.findViewById(R.id.tv_0);
            holder.tv_1 = (TextView)view.findViewById(R.id.tv_1);
            holder.tv_2 = (TextView)view.findViewById(R.id.tv_2);
            holder.tv_3 = (TextView)view.findViewById(R.id.tv_3);
            holder.tv_4 = (TextView)view.findViewById(R.id.tv_4);
            holder.tv_5 = (TextView)view.findViewById(R.id.tv_5);
            holder.llv_test = (ListLineView)view.findViewById(R.id.llv_test);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_0.setText(String.valueOf(listTestBean.get(i).getList().get(0)));
        holder.tv_1.setText(String.valueOf(listTestBean.get(i).getList().get(1)));
        holder.tv_2.setText(String.valueOf(listTestBean.get(i).getList().get(2)));
        holder.tv_3.setText(String.valueOf(listTestBean.get(i).getList().get(3)));
        holder.tv_4.setText(String.valueOf(listTestBean.get(i).getList().get(4)));
        holder.tv_5.setText(String.valueOf(listTestBean.get(i).getList().get(5)));


        int temX = holder.tv_0.getWidth()/2;
        if(temX != 0 && listPoint.size() == 0){
            listPoint.add(holder.tv_0.getX() + temX);
            listPoint.add(holder.tv_1.getX()+ temX);
            listPoint.add(holder.tv_2.getX()+ temX);
            listPoint.add(holder.tv_3.getX()+ temX);
            listPoint.add(holder.tv_4.getX()+ temX);
            listPoint.add(holder.tv_5.getX()+ temX);
        }

        if(listPoint.size() != 0){
            holder.llv_test.setValue(String.valueOf(listTestBean.get(i).getList().get(listTestBean.get(i).getSelectN())));
            if(!listTestBean.get(i).isMid()){
                float x = listPoint.get(listTestBean.get(i).getSelectN());
                holder.llv_test.setCurrent(x);
            }
            if(i > 0){
                holder.llv_test.setUp(listPoint.get(listTestBean.get(i).getUpSelect()),listTestBean.get(i).getUpNum());
            }
            else{
                holder.llv_test.setUp(null);
            }
            if(i < listTestBean.size() - 1){
                holder.llv_test.setDown(listPoint.get(listTestBean.get(i).getDownSelect()),listTestBean.get(i).getDownNum());
            }
            else{
                holder.llv_test.setDown(null);
            }
            holder.llv_test.setMid(listTestBean.get(i).isMid());
            holder.llv_test.upUI();
        }

        return view;
    }


    public class ViewHolder {
        TextView tv_0;
        TextView tv_1;
        TextView tv_2;
        TextView tv_3;
        TextView tv_4;
        TextView tv_5;
        ListLineView llv_test;
    }
}
