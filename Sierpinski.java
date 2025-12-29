/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
		double height = Math.sqrt(3) / 2; // approx 0.866
        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(1.0, 0.0, 0.5, height);
		StdDraw.line(0.5, height, 0.0, 0.0);   // Left Side
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		double height = Math.sqrt(3) / 2; // approx 0.866
		sierpinski (n, 0.0, 1.0, 0.5, 0.0, 0.0, height);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		double x12 = (x1 + x2) / 2;
		double y12 = (y1 + y2) / 2;
		double x23 = (x2 + x3) / 2;
		double y23 = (y2 + y3) / 2;
		double x31 = (x3 + x1) / 2;
		double y31 = (y3 + y1) / 2;
		if (n == 0) { return; } // base case
		StdDraw.line(x12, y12, x23, y23);
		StdDraw.line(x23, y23, x31, y31);
		StdDraw.line(x31, y31, x12, y12);
		
		sierpinski (n-1, x1, x12, x31, y1, y12, y31); //left triangle
		sierpinski (n-1, x12, x2, x23, y12, y2, y23); //right triangle
		sierpinski (n-1, x31, x23, x3, y31, y23, y3); //top triangle
	}
}
