package com.atguigu.test;

import org.junit.Test;

public class DabaTest {
	
	@Test
	public void test01(){
		int a = 10;
		System.out.println(++a);//11
		System.out.println(a);//11
	}
	
	
	
	@Test
	public void test02(){
		System.out.println(-1 % 5);//-1
	}

	@Test
	public void test03(){
		//打印100以内的质数
		boolean flag = true;
		for(int i = 2; i <= 100; i++){
			for(int j = 2; j < i; j++){
				if(i % j == 0){
					//该数一定不是质数
					flag = false;
				}
			}
			if(flag){
				System.out.println(i);
			}
			flag = true; //使标记重新生效
		}

	}
}
