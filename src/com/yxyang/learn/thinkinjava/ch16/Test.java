package com.yxyang.learn.thinkinjava.ch16;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		//数组声明的3种方式
		int[] a1 = new int[5];
		int[] a2 = {1,2,3};
		int[] a3 = new int[] {1,2,3};
		
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println(Arrays.toString(a3));
	
		int [][]da1 = new int[2][2];
		
		da1[0][0] = 1;
		da1[0][1] = 2;
		da1[1][0] = 33;
		da1[1][1] = 4;
		int [][]da2 = {
				{1, 2, 3},
				{4, 5, 6}
		};
		
		System.out.println(Arrays.deepToString(da1));
		System.out.println(Arrays.deepToString(da2));
		
		int m =10;
		int n =20;
		int[][] arr = new int[m][n];
	}
}
