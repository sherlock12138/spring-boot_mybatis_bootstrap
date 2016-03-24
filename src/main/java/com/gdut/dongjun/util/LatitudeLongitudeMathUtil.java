package com.gdut.dongjun.util;

/**
 * @author Sherlock-lee
 * @date 2016年1月25日 下午2:15:55
 * @see TODO
 * @since 1.0
 */
public class LatitudeLongitudeMathUtil {

	/**
	 * 
	 * @Title: latlong2float
	 * @Description: TODO
	 * @param @param latlong
	 * @param @return
	 * @return float
	 * @throws
	 */
	public static float latlong2float(String latlong) {

		if (latlong != null) {
			String[] tmp = latlong.split("°");

			float x = Float.parseFloat(tmp[0]);
			latlong = tmp[1];
			tmp = latlong.split("'");

			float y = Float.parseFloat(tmp[0]);
			latlong = tmp[1];

			tmp = latlong.split("\"");

			float z = Float.parseFloat(tmp[0]);

			return x + y / 60 + z / 3600;
		} else {
			return 0;
		}
	}
}
