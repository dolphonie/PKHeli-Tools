public class PiecewiseLinearFunctionGenerator {
	public static final double JOINT_ABSCISSA_FRACTION = .6;
	public static final double LOW_SLOPE = 0.166666666666666666666666666;

	public static void main(String[] args) {
		System.out.println("Piecewise Function Generator V 1.0");
		System.out
				.println("Patrick Company: Where we believe \"Patrick is Awesome (And Modest Too)\"");
		Fraction lowSlopeFraction = calculateFraction(LOW_SLOPE);
		int jointAbscissa = (int) (256 * JOINT_ABSCISSA_FRACTION);
		int jointOrdinate = (int) (jointAbscissa * lowSlopeFraction.num / lowSlopeFraction.den);
		double highSlope = (double) (255 - jointOrdinate)
				/ (double) (255 - jointAbscissa);// 255 intentionally
		Fraction highSlopeFraction = calculateFraction(highSlope);
		int endOrdinate = (255-jointAbscissa)*highSlopeFraction.num/highSlopeFraction.den + jointOrdinate;
		int ordinateAdjustment = 255-endOrdinate;
		
		System.out.println("Low Slope Fractional: " + lowSlopeFraction);
		System.out.println("Joint Abscissa: " + jointAbscissa);
		System.out.println("Ordinate Adjustment: " + ordinateAdjustment);
		System.out.println("Joint Ordinate Adjusted: " + (jointOrdinate+ ordinateAdjustment));
		System.out.println("High Slope Decimal: " + highSlope);
		System.out.println("High Slope Fractional: " + highSlopeFraction);
	}

	private static Fraction calculateFraction(double dec) {
		int denominator = 512;
		int numerator = Integer.MAX_VALUE;
		while (numerator > 255) {
			denominator /= 2;
			numerator = (int) Math.round(denominator * dec);
		}
		return new Fraction(numerator, denominator);
	}

	private static class Fraction {
		public int num;
		public int den;

		public Fraction(int numer, int denom) {
			num = numer;
			den = denom;
		}

		public String toString() {
			return num + "/" + den;
		}
	}

}
