package quadPrograms;

public class PiecewiseLinearFunctionGenerator {
	public static final double JOINT_ABSISSA = .6;
	public static final double LOW_SLOPE = 0.16666666666;

	public static void main(String[] args) {
		System.out.println("Piecewise Function Generator V 1.0");
		System.out.println("Patrick Company: Where we believe \"Patrick is Awesome (And Modest Too)\"");
		int jointAbsissa = (int) (256 * JOINT_ABSISSA);
		int jointOrdinate = (int) (256d * LOW_SLOPE * JOINT_ABSISSA);
		double highSlope = (double)(255-jointOrdinate) / (double)(255-jointAbsissa);//255 intentionally
		int highSlopeModifier = (int) (highSlope * 64d);
		System.out.println("Joint Absissa: " + jointAbsissa);
		System.out.println("Joint Ordinate: " + jointOrdinate);
		System.out.println("High Slope Decimal: " + highSlope);
		System.out.println("High Slope Fractional: " + highSlopeModifier + "/64");
	}

}
