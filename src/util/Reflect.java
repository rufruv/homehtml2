package util;
import java.lang.reflect.*;
import java.util.*;
public class Reflect {
	public static void main(String[] args) {
		try {
			Class klass = Class.forName("domain.DatabaseBean");
			Method[] arr = klass.getDeclaredMethods();
			Set<String> set = new HashSet<String>();
			for(Method m:arr){
				set.add(m.getName());
			}
			System.out.println(set.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}