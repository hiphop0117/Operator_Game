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
	
	
	
	public static void main(String []args) {
		final int NUMBER_OF_PROBLEM = 3;
		long start = System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);
		
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
		
		scan.close();	
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
//		System.out.print("\n");
	}
		
	public static String methodName() {
		
		System.out.println("Press Enter to continue");
		try{System.in.read();}
		catch(Exception e){}
		
		long start = System.currentTimeMillis();
		System.out.println("Hello World");
		
		long end = System.currentTimeMillis();
		System.out.println(end +" "+ start);
		System.out.println( "run time: " + ( end - start )/1000.0 );
		

		
		return "Fantastic Park";
	}
}
