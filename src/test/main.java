package test;

import java.util.Scanner;
import java.util.Random;

class Problem{
	int frontNumber;
	boolean operator;
	int backNumber;
	
	public Problem(){
		this.frontNumber = 0;
		this.operator = false;
		this.backNumber = 0;
	}
}

class MyProgram {
	public static void main(String []args) {
		for (int i = 0; i < 10;i++){		
			Problem randomProblem = getRandomProblem();
			printProblem(randomProblem);
		}
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
		System.out.print("\n");
	}
		
	public static String methodName() {
		
		System.out.println("Press Enter to continue");
		try{System.in.read();}
		catch(Exception e){}
		
		long start = System.currentTimeMillis();
		System.out.println("Hello World");
		int message;
		Scanner scan = new Scanner(System.in);   
	        
		System.out.println("input:");
	        
		message = scan.nextInt();
		System.out.println(message);
		
		long end = System.currentTimeMillis();
		System.out.println(end +" "+ start);
		System.out.println( "run time: " + ( end - start )/1000.0 );
		
		scan.close();
		
		return "Fantastic Park";
	}
}
