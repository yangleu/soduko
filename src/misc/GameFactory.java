package misc;

import java.awt.Color;

import javax.swing.Spring;
import javax.swing.SpringLayout;

public  class GameFactory {
	public static Color CrossCellColor = Color.PINK;
	public static Color BaseCellColor = Color.white;
	public static GameConfiguration GameConfig = new GameConfiguration();

	public static Color getBackgroundColor(int row, int column) {
		Color mycolor=BaseCellColor;
		
    	if ( ( (5<row) || (3>row) ) && ( (5<column) || (3>column)  ) ) { // 4 corners
    		mycolor = GameFactory.BaseCellColor;
    	} else {
    		if ( ( (6>row) && (2<row) ) && ( (6>column) && (2<column)  ) ) // The center cell
    			mycolor = GameFactory.BaseCellColor;
    		else
    			mycolor = GameFactory.CrossCellColor;
    	}		
		
		return mycolor;
	}
	
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
	
	public static void log(String logMsg) {
		System.out.println(logMsg);
	}
	
	public static void log(int level, String logMsg) {
		String prefix="";
		for (int i=0;i<level;i++) prefix=prefix+"   ";
		System.out.println(prefix+logMsg);
	}
}
