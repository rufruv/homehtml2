package util;
import java.util.Scanner;
import java.io.*;
public class FileUtil {
	public static void main(String[] args) { //main method에 throw를 던지면 안돼!
		Scanner s = new Scanner(System.in);
		File file = new File("C:\\Users\\hb2002\\eclipse\\test.txt");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true)); // Pattern : decorator
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String msg="";
			while(true){
				System.out.println("[메뉴] 0.종료 1.쓰기 2.읽기");
				switch(s.next()){
				case "0":
					writer.close();
					return;
				case "1":
					System.out.println("메시지 입력");
					writer.write(s.next());
					writer.newLine();
					writer.flush();
					break;
				case "2":
					System.out.println("메시지 보기");
					while((msg=reader.readLine())!=null){
						System.out.println(msg);
					}
					reader.close();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}