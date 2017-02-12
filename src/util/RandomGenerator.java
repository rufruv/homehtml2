package util;

public class RandomGenerator {
	public static int getRandomNum(int a, int b){
		/*int large=0, small = 0, sh=0 ;
		sh=(a>b)?(int)(Math.random()*(a-b+1))+ b:(int)(Math.random()*(b-a+1))+ a;
		if(a>b){
			large =a;
			small =b;
		}else{
			large= b;
			small= a;
		}*/
		return (a>b)?(int)(Math.random()*(a-b+1))+b:(int)(Math.random()*(b-a+1))+a;
	}
}