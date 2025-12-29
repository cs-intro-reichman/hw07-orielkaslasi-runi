/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		// curve(Integer.parseInt(args[0]),
		// 	  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		//       Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0])); 
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n==0) {
		StdDraw.line(x1, y1, x2, y2);
		return;
		}
		double xp1 = (2 * x1 + x2) / 3;
		double yp1 = (2 * y1 + y2) / 3;
		double xp2 = (x1 + 2 * x2) / 3;
		double yp2 = (y1 + 2 * y2) / 3;

		double xPeak = (x1 + x2) / 2 + Math.sqrt(3) / 6 * (y1 - y2);
    	double yPeak = (y1 + y2) / 2 - Math.sqrt(3) / 6 * (x1 - x2); 

		curve ( n - 1, x1, y1, xp1, yp1); //from x1 y1 to p1
		curve ( n - 1, xp1, yp1, xPeak, yPeak); //from p1 to peak
		curve ( n - 1, xPeak, yPeak, xp2, yp2);  //peak to p2
		curve ( n - 1, xp2, yp2, x2, y2); //p2 to x2y2
		}
		

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		double height = Math.sqrt(3) / 2;
		
		curve(n, 0.0, 0.0, 0.5, height);
		curve(n, 0.5, height, 1.0, 0.0);
		curve(n, 1.0, 0.0, 0.0, 0.0);
	}
}
