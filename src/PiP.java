import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PiP {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Point> polygon = new ArrayList<Point>();
		Scanner scan = new Scanner(new File("input.txt"));
		
		while(scan.hasNextInt()) {
			int polygonPointsNum = scan.nextInt();
			int pointsNum = scan.nextInt();
			
			polygon.clear();
			for (int i = 0; i < polygonPointsNum; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				polygon.add(new Point(x, y));
			}
			
			for (int i = 0; i < pointsNum; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				
				if(isInPolygon(new Point(x, y), polygon))
					System.out.println("in");
				else
					System.out.println("out");
			}
			System.out.println();
		}

		scan.close();
	}
	
	public static boolean isInPolygon(Point p, ArrayList<Point> polygon) {
		polygon.add(polygon.get(0));
		
		int counter = 0;
		
		for(int i = 0; i < polygon.size() - 1; i++) {
			Point oa = polygon.get(i);
			Point da = differenceVector(polygon.get(i+1), polygon.get(i));
			
			Point ob = p;
			Point db = new Point(1, 0);
			
			Point invda = new Point(da.y, -da.x);
			Point invdb = new Point(db.y, -db.x);
			
			double numerator = dotProduct(differenceVector(ob, oa), invdb);
			double denominator = dotProduct(da, invdb);
			double t = numerator / denominator;
			
			numerator = dotProduct(differenceVector(oa, ob), invda);
			denominator = dotProduct(db, invda);
			double s = numerator / denominator;
			
			if(t >= 0 && t <= 1 && s >= 0)
				counter++;
		}
		return (counter % 2) != 0;
	}
	
	public static Point differenceVector(Point p1, Point p2) {
		return new Point(p1.x - p2.x, p1.y - p2.y);
	}
	
	public static double dotProduct(Point p1, Point p2) {
		return p1.x * p2.x + p1.y * p2.y;
	}
	
	
}
