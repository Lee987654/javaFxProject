package object_oriented_programming;

import java.util.Random;
import java.util.Scanner;


public class java_object_oriented_exercise3_baseball {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();
	int[] n = new int[3];
			int[] guess = new int[3];
					boolean[] already = new boolean[10];
	int strike, ball;
	
	
	for (int i =0; i < 10; i++) {
		already[i] = false;
		
	}
	int count = 0;
	while (count <3) {
		int trial = rand.nextInt(10);
		if (!already[trial]) {
			n[count] = trial;
			already[trial] = true;
			count++;
		}
	}
	
	boolean finish = false;
			while (!finish) {
				strike = ball = 0;
				System.out.print("0~9 사이의 세 정수를 입력하세요.>>");
				for (int k = 0; k < 3; ++k) {
					guess[k] = sc.nextInt();
					for (int j=0; j < 3; ++j)
						if (guess[k] ==n[j]) {
							if (k==j) strike++;
							else ball++;
						}
				}
			System.out.println(strike + "스트라이크" + ball + "볼");
			if (strike ==3)
				finish = true;
			
			}
	sc.close();
	for (int j=0; j<3; ++j)
		System.out.print(n[j] + "");
	System.out.println(": 축하합니다!");
	}

			
			}









