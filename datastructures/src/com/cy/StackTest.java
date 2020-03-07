package com.cy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		String  nifixExpression = "1+((2+3)*4)-5";
		List<String> list = toNifixExpressionList(nifixExpression);
		String postfixExpression = nifixExpressionList2PostfixExpression(list);
		System.out.println(postfixExpression);
	}
	
	public static String nifixExpressionList2PostfixExpression(List<String> nifixExpressionList) {
		Stack<String> s1=new Stack<>();
		List<String> s2=new ArrayList<>();
		for (String item : nifixExpressionList) {
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if(item.equals("(")) {
				s1.push(item);
			}else if(item.equals(")")){
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();
			}else {
				while(s1.size()!=0&&getValue(item)<=getValue(s1.peek())) {
					s2.add(s1.pop());
				}
				s1.push(item);
			}
		}
		
		while(s1.size()!=0) {
			s2.add(s1.pop());
		}
		
		return s2.toString();
	}
	
	public static int getValue(String str) {
		int value=0;
		switch (str) {
		case "+":
			value=1;
			break;
		case "-":
			value=1;
			break;
		case "*":
			value=2;
			break;
		case "/":
			value=2;
			break;
		default:
			System.out.println("没有此运算符号");
			break;
		}
		return value;
		
	}
	
	public static List<String> toNifixExpressionList(String s){
		List<String> list=new ArrayList<>();
		int index=0;
		String str="";
		while(index<s.length()) {
			if(s.substring(index, index+1).matches("[0-9]")) {
				str="";
				while(index<s.length()&&s.substring(index, index+1).matches("[0-9]")) {
					str+=s.substring(index, index+1);
					index++;
				}
				list.add(str);
			}else {
				list.add(s.substring(index, index+1));
				index++;
			}
		}	
		
		return list;
	}
}
