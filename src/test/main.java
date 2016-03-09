package test;

import java.util.Scanner;
import java.util.Random;

class Problem{
	int frontNumber;
	boolean operator;  //true= x, false= +
	int backNumber;
	
	public Problem(){
		this.frontNumber = 0;
		this.operator = false;
		this.backNumber = 0;
	}
}



class MyProgram {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String []args) {
		final int MENU_GAME_START = 1;
		final int MENU_GAME_RANK  = 2;
		final int MENU_GAME_END   = 3;
		
		//메뉴화면		
		System.out.println("1.게임하기\n2.랭킹보기\n3.종료\n무엇을 할지 입력하세요(1-3)");
	
		int userAnswer = scan.nextInt();
		switch (userAnswer){				
		case MENU_GAME_START: 
			getGametime();
			break;
		case MENU_GAME_RANK:
			System.out.println("미구현");
			break;
		case MENU_GAME_END:
			System.out.println("게임을 종료합니다.");
			break;	
		default:
			System.out.println("제대로 입력하세요.");
			break;
		}
		
		
	}
	
	public static void getGametime() {
		final int NUMBER_OF_PROBLEM = 3;
		long start = System.currentTimeMillis();
		
		
		//Generate 10 problem
		for (int i = 0; i < NUMBER_OF_PROBLEM;i++){
			Problem randomProblem = getRandomProblem();
			int userAnswer =0;// = scan.nextInt();
			
			while(userAnswer != getTrueAnswer(randomProblem)){
				
				printProblem(randomProblem);
				userAnswer = scan.nextInt();
			}
			
			System.out.println("("+(i+1)+")");
		}
		
		long end = System.currentTimeMillis();		
		System.out.println( "run time: " + ( end - start )/1000.0 + "sec");
		
		
	}
	
	public static int getTrueAnswer(Problem p) {
		int TrueAnswer;
		if(p.operator){
			TrueAnswer=p.frontNumber*p.backNumber;
		}
		else{
			TrueAnswer=p.frontNumber+p.backNumber;				
		}
		return TrueAnswer;
	}
		
	public static int getRandomNumber() {
		Random oRandom = new Random();
		return oRandom.nextInt(9)+1;
	}
	
	public static boolean getRandomProblemType() {
		Random oRandom = new Random();
		return oRandom.nextBoolean();
	}
	
	public static Problem getRandomProblem() {		
		Problem pro = new Problem();
		pro.frontNumber = getRandomNumber();
		pro.operator = getRandomProblemType();
		pro.backNumber = getRandomNumber();
		
		return pro;
	}
	
	public static void printProblem(Problem pro) {		
		System.out.print(pro.frontNumber);
		 
		if(pro.operator){
			System.out.print("x");
		}
		else{
			System.out.print("+");
		}
		
		System.out.print(pro.backNumber);
		System.out.print("=");
	}
}
