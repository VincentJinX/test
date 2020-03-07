package com.cy;

public class Queen8 {
	private int max=8;
	private int count=0;
	private int[] arr=new int[max];
	public static void main(String[] args) {
		Queen8 queen8 = new Queen8();
		queen8.check(0);
		System.out.println(queen8.count);
	}
	
	
	private void check(int n) {
		if(n==max) {
			print();
			return;
		}
		
		for(int i=0;i<max;i++) {
			arr[n]=i;
			if(judge(n)) {
				check(n+1);
			}
		}
	}
	
	private void print() {
		count++;
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	private boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			if(arr[i]==arr[n]|| Math.abs(n-i)==Math.abs(arr[n]-arr[i])) {
				return false;
			}
		}
		return true;
		
	}
}
