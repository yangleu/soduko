package misc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.Spring;
import javax.swing.SpringLayout;

public  class LeoLog {
	public static void print(String msg) {
		System.out.print(msg);
	}
	
	public static void println(String msg) {
		System.out.println(msg);
	}
	
	public static void printSpring(Spring sp, String prefix) {
		System.out.println(prefix + " Max:\t" + sp.getMaximumValue()  
								  + " Min:\t" + sp.getMinimumValue()
								  + " Preffered:\t" + sp.getPreferredValue()
								  + " Value:\t" + sp.getValue() 
					);
	}
	
	public static void printConstraint (SpringLayout.Constraints cons, String prefix) {
		String edges[] = {SpringLayout.NORTH, SpringLayout.EAST, SpringLayout.SOUTH, SpringLayout.WEST};
		String elements[] = {"getHeight", "getWidth", "getX", "getY"};
		System.out.println(prefix);
		Spring _Spring;
//		for (int i=0; i<4; i++) {
//			System.out.print("\t"+ edges[i]);
//			_Spring = cons.getConstraint(edges[i]);
//			printSpring(_Spring, "\t\t");
//		}
		
		System.out.print("\t" + "getHeight");
		_Spring = cons.getHeight();
		printSpring(_Spring, "\t");

		System.out.print("\t" + "getWidth");
		_Spring = cons.getWidth();
		printSpring(_Spring, "\t");

		System.out.print("\t" + "getX");
		_Spring = cons.getX();
		printSpring(_Spring, "\t\t");

		System.out.print("\t" + "getY");
		_Spring = cons.getY();
		printSpring(_Spring, "\t\t");
		
//		for (int i=0; i<4; i++) {
//			System.out.println("\t"+ elements[i]);
//				try {
//					Method consMethod = SpringLayout.Constraints.class.getMethod(elements[i], null);
//					LeoLog.println(consMethod.getName());
//					_Spring = (Spring) (consMethod.invoke(null));
//					printSpring(_Spring, "\t\t");
//				} catch (NoSuchMethodException | SecurityException
//						| IllegalAccessException | IllegalArgumentException
//						| InvocationTargetException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					
//				}
//			
//		}
		
	}
}
