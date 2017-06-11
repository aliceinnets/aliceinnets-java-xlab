package aliceinnets.xlab.kde;

public class PlayKde {
	
	double numPoints;
	double numTotalPoints;
	
	/**
	 * We need a penalty term for the cover range. If cover range is small then pdf should not be perferable.
	 */
	double coverRange;
	/**
	 * The cover range could be defined as confidential interval. If confidential interval 95% 
	 * then the most probably case is the confidential interval contains 95% of the data. This criteria will
	 * exclude the most undesirable cases, either too small or big window length. 
	 */
	double confidentialInterval;
	
	double evidence;
	double posterior;

}
