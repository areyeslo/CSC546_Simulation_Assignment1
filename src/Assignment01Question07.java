import java.util.Random;
import java.util.regex.Pattern;

public class Assignment01Question07 {

	public static void main(String[] args) {
		double p1 = 0.0001;
		double totalHead   = 0;
		double totalTail   = 0;
		int tossTime       = 100000;

		int digitNumber = Double.toString(p1).split(Pattern.quote("."))[1].length(); // number of digit after decimal point
		
		System.out.println("Digit Number: " + digitNumber);
		int range    = (int)Math.pow(10, digitNumber+1); 

		Random random = new Random();
		
		System.out.println("range: "+range);
		for (int i=0; i < tossTime;i++) {
			int tossCoin = random.nextInt(range);
			//System.out.println("TossCoin: " + tossCoin);
			//System.out.println(tossCoin);
			if (tossCoin < (p1*range)){
				totalHead = totalHead + 1;
			}
			else{
				totalTail = totalTail +1;
				//System.out.println("Total Tail: " + totalTail);
			}
		}

		System.out.println("range    : " + range);
		System.out.println("tossTime : " + tossTime);
		System.out.println("totalHead: " + totalHead);
		System.out.println("totalTail: " + totalTail);
		System.out.println("----------------");
		System.out.printf("Possibility = %.16f\n", p1);
		System.out.printf("Estimated p = %.16f\n", (totalHead/tossTime));
		double error= Math.abs(
				(p1 -(totalHead/tossTime))
				/p1);
		System.out.printf("Normalized Estimation Error= %.10f\n", error);
	}

}
