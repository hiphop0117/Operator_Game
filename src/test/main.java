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
			//�޴�ȭ��		
			System.out.println("1.�����ϱ�\n2.��ŷ����\n3.����\n������ ���� �Է��ϼ���(1-3)");
			
			int userAnswer = scan.nextInt();
			switch (userAnswer){				
			case MENU_GAME_START: 
				GameEngine.getGametime();
				break;
			case MENU_GAME_RANK:
				System.out.println("�̱���");
				break;
			case MENU_GAME_END:
				isNotEnd = false;
				System.out.println("������ �����մϴ�.");
				break;	
			default:
				System.out.println("����� �Է��ϼ���.");				
				break;
			}
		}
	}
}
