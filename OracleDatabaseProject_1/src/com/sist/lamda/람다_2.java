package com.sist.lamda;

public class 람다_2{

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		// 쓰레드 구현
//		System.out.println("쓰레드 구동!!");
//	}
//	public static void main(String[] args) {
//		람다_2 a = new 람다_2();
//		new Thread(a).start();;
		
//	}
	public static void main(String[] args) {
		Runnable t=()->
			System.out.println("쓰레드 구동");
			t.run();
		
	}
}
