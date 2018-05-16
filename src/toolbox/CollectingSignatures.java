package toolbox;

import java.util.Scanner;
import java.util.Vector;

public class CollectingSignatures {
	private static Scanner scan;

	private static class segment {
		int start, end;

		segment(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int n = scan.nextInt();
		segment[] segments = new segment[n];

		for (int i = 0; i < n; i++) {
			int start, end;
			start = scan.nextInt();
			end = scan.nextInt();
			segments[i] = new segment(start, end);
		}
		Vector<Integer> points = optemalPoints(segments);
		System.out.println(points.size());
		for (int i=0 ; i< points.size() ; i++) {
			System.out.print(points.get(i) + " ");
		}

	}

	private static Vector<Integer> optemalPoints(segment[] segments) {
		sortByEndPoint(segments);
		Vector<Integer> points = new Vector<Integer> ();
		int lastPoint = segments[0].end;
		points.add(lastPoint);
		int len =segments.length;
		for (int i=1 ;i < len ; i++){
			if (!(lastPoint >= segments[i].start && lastPoint <= segments[i].end)){
				lastPoint = segments[i].end;
				points.add(lastPoint);
			}
		}
		return points;
	}

	private static void sortByEndPoint(segment[] segments) {
		// TODO Auto-generated method stub
		int len =segments.length ; 
		for (int i=0 ; i< len ; i++){
			for (int j=0 ; j<len-1 ; j++){
				if (segments[j].end > segments[j+1].end){
					segment s =new segment(segments[j].start,segments[j].end);
					segments[j]=segments[j+1];
					segments[j+1]=s ;
					
				}
			}
		}
		
	}
}
