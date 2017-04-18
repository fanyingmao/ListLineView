package com.example.fanyingmao.test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MyMath {
	// 获取从N取M的组合数
	public static long getCombination(int n, int m) {
		long res = getPermutations(n, m) / getPermutations(m, m);
		return res;
	}

	// 获取从N取M的排列数 --当 n = m 时就为n！
	public static long getPermutations(int n, int m) {
		long res = 1;
		for (int i = 0; i < m; i++) {
			res = res * (n - i);
		}
		return res;
	}

	// 返回0-n 随机数
	public static int getRandInt(int n) {
		java.util.Random random = new java.util.Random();// 定义随机类
		int result = random.nextInt(n);// 返回[0,car_10)集合中的整数，注意不包括10
		return result;
	}

	// 返回1-49不重复7位随机数
	public static String getRand1_49() {
		String str = "";
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 49; i++) {
			if(i +1 < 10){
				list.add("0"+(i + 1));
			}
			else{
				list.add(""+(i + 1));
			}
		}

		for (int i = 0; i < 7; i++) {
			int rand = getRandInt(49 - i);
			str += list.get(rand);
			if(i != 6){
				str += ",";
			}
			list.remove(rand);
		}
		return str;
	}
	
	// 返回1-49不重复7位随机数
		public static ArrayList<Integer> getRand1_10() {
			ArrayList<Integer> listInt = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				list.add(i);
			}

			for (int i = 0; i < 10; i++) {
				int rand = getRandInt(10 - i);
				listInt.add(list.get(rand));

				list.remove(rand);
			}
			return listInt;
		}
}
