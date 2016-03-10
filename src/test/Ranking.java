package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Result implements Serializable{
	String name;
	double time;
	
	public Result(){
		this.name = "Park";
		this.time = 999.0;
	}
}

public class Ranking {
	final static int COUNT_OF_RANK   = 10;
	final static String RANKING_FILE_PATH = "rank.sav";
	
	public static boolean checkNoFile() throws IOException{
	    File f = new File(RANKING_FILE_PATH);
	    // 파일 존재 여부 판단	    
	    return !(f.isFile());
	}	
	
    public static void MakeFile() throws IOException {
        FileOutputStream output = new FileOutputStream(RANKING_FILE_PATH);
        output.close();
    }
	
	public static void printRank(Result[] res){
		for(int i = 0; i < COUNT_OF_RANK; i++){
			System.out.println(res[i].name+" "+res[i].time);
		}		
	}
	
	public static void writeRank(Result[] res)throws IOException{
		FileOutputStream outputStream = new FileOutputStream(RANKING_FILE_PATH);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(bos);
		for (int i = 0; i < COUNT_OF_RANK; i++){
			out.writeObject(res[i]);
		}
		
		byte[] yourBytes = bos.toByteArray(); 
		
		outputStream.write(yourBytes);
		outputStream.close();
	}
	
	public static void readRank()throws IOException{
		FileInputStream inputStream = new FileInputStream(RANKING_FILE_PATH);
		byte[] readBuffer = new byte[1024];
		
		inputStream.read(readBuffer);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(readBuffer);
		ObjectInput in = new ObjectInputStream(bis);
		try {
			in.
			Object o = in.readObject();
			System.out.println(o);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}

