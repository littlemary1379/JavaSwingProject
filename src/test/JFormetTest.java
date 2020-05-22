package test;

import javax.swing.JFrame;

public class JFormetTest extends JFrame{

	public static void main(String[] args) {
		String regExp="^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$";
		String Email1="010-00000-0000";
		System.out.println("테스트 결과 : "+Email1.matches(regExp));
	}
}
