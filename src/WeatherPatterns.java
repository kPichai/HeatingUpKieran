import java.util.Arrays;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Kieran Pichai
 */

public class WeatherPatterns {

    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        int[] counts = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = 0; j < i; j++) {
                if (temperatures[i] > temperatures[j] && counts[i] < counts[j] + 1) {
                    counts[i] = counts[j] + 1;
                }
            }
        }

        int maxLength = 0;
        for (int len : counts) {
            maxLength = Math.max(maxLength, len);
        }

        return maxLength;
    }
}
