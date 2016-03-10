package test;

import java.util.Scanner;
import java.io.*;



class MyProgram {	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String []args) throws IOException {
		final int MENU_GAME_START = 1;
		final int MENU_GAME_RANK  = 2;
		final int MENU_GAME_END   = 3;

		boolean isNotEnd = true;
		
		Result[] dummyData = new Result[Ranking.COUNT_OF_RANK];
		for(int i = 0; i < Ranking.COUNT_OF_RANK; i++){
			int dummyName = 'A'+i;
			dummyData[i] = new Result();
			dummyData[i].name = ""+(char)dummyName+(char)dummyName+(char)dummyName;
			dummyData[i].time = 9.0+i;			
		}
		Ranking.printRank(dummyData);
		//Ranking.writeRank(dummyData);
		Ranking.readRank();
		
		
		if (Ranking.checkNoFile()){
			Ranking.MakeFile();
		}
  
		while(isNotEnd){			
			//메뉴화면		
			System.out.println("1.게임하기\n2.랭킹보기\n3.종료\n무엇을 할지 입력하세요(1-3)");
			
			int userAnswer = scan.nextInt();
			switch (userAnswer){				
			case MENU_GAME_START: 
				GameEngine.getGametime();
				break;
			case MENU_GAME_RANK:
				System.out.println("미구현");
				break;
			case MENU_GAME_END:
				isNotEnd = false;
				System.out.println("게임을 종료합니다.");
				break;	
			default:
				System.out.println("제대로 입력하세요.");				
				break;
			}
		}
	}
}
