import java.util.*;

public class PaintingCost {
	public static void main ( String[] args ) {
		Scanner sc = new Scanner ( System.in );
		int inter, exter;
		inter = sc.nextInt();
		exter = sc.nextInt();
		double iarea=0, earea=0;
		for ( int i = 0; i < inter; i++ )
			iarea += sc.nextDouble();
		for ( int i = 0; i < exter; i++ )
			earea += sc.nextDouble();
		double cost= iarea*18+ 12*earea;
		System.out.println(cost+" INR");
		sc.close();
	}
}