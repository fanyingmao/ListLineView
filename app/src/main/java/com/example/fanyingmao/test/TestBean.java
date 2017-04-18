package com.example.fanyingmao.test;

import java.util.ArrayList;

/**
 * Created by fanyingmao on 2017/car_3/car_8.
 */

public class TestBean {
    private ArrayList<Integer> list;

    private int upNum = 0,downNum = 0;
    private int upSelect = 0,downSelect = 0;

    private boolean isMid;
    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
    private int selectN;

    public int getSelectN() {
        return selectN;
    }

    public void setSelectN(int selectN) {
        this.selectN = selectN;
    }

    public int getUpNum() {
        return upNum;
    }

    public void setUpNum(int upNum) {
        this.upNum = upNum;
    }

    public int getDownNum() {
        return downNum;
    }

    public void setDownNum(int downNum) {
        this.downNum = downNum;
    }

    public boolean isMid() {
        return isMid;
    }

    public void setMid(boolean mid) {
        isMid = mid;
    }

    public int getUpSelect() {
        return upSelect;
    }

    public void setUpSelect(int upSelect) {
        this.upSelect = upSelect;
    }

    public int getDownSelect() {
        return downSelect;
    }

    public void setDownSelect(int downSelect) {
        this.downSelect = downSelect;
    }
}
