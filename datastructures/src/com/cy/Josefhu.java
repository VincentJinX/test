package com.cy;


public class Josefhu {
	public static void main(String[] args) {
		CircleSingleLinkedList boys = new CircleSingleLinkedList();
		boys.addBoy(125);
		boys.showBoy();
		boys.countBoy(10, 20, 125);
	}
}

class CircleSingleLinkedList{
	private Boy first=new Boy(-1);
	public void addBoy(int nums) {
		if(nums<1) {
			System.out.println("nums值不正确");
			return;
		}
		Boy curBoy=null;
		for(int i=1;i<=nums;i++) {
			Boy boy=new Boy(i);
			if(i==1) {
				first=boy;
				first.setNext(first);
				curBoy=first;
				
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy=boy;
			}
		}
	}
	
	public void showBoy() {
		if(first==null) {
			System.out.println("链表为空");
			return;
		}
		Boy curBoy=first;
		while(true) {
			System.out.println("学生的编号:"+curBoy.getNo());
			if(curBoy.getNext()==first) {
				return;
			}
			curBoy=curBoy.getNext();
		}
	}
	
	public void countBoy(int startNo,int countNum,int nums) {
		if(first==null||startNo<1||startNo>nums) {
			System.out.println("参数输入有误,请重新输入");
			return;
		}
		for(int i=0;i<startNo-1;i++) {
			first=first.getNext();
		}
		Boy helper=first;
		while(true) {
			if(helper.getNext()==first) {
				break;
			}
			helper=helper.getNext();
		}
		while(true) {
			if(helper==first) {
				break;
			}
			for(int i=0;i<countNum-1;i++) {
				first=first.getNext();
				helper=helper.getNext();
			}
			System.out.println("出圈的编号为:"+first.getNo());
			first=first.getNext();
			helper.setNext(first);
		}
		System.out.println("最后在圈内的编号为:"+first.getNo());
	}
}

class Boy{
	private int no;
	private Boy next;
	public Boy(int no) {
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNext() {
		return next;
	}
	public void setNext(Boy next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "Boy [no=" + no + ", next=" + next + "]";
	}
	
}
