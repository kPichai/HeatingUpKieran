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
    // Method that calculates the longest run of increasing temperature values
    public static int longestWarmingTrend(int[] temperatures) {
        // Array to store counts of consecutive increasing temperatures
        int[] counts = new int[temperatures.length];
        int maxLength = 0;

        // Iterate through the temperatures to compare each to previous values
        for (int i = 1; i < temperatures.length; i++) {
            // Double for loop to check everything before your current spot in temperatures as well
            for (int j = 0; j < i; j++) {
                // Check if a longer increasing sequence can be formed with our current temperature value
                if (temperatures[i] > temperatures[j] && counts[i] < counts[j] + 1) {
                    counts[i] = counts[j] + 1;
                }
            }
            // Calculates and stores the longest sequence length so far
            maxLength = Math.max(maxLength, counts[i]);
        }

        // Add 1 to include the starting temperature in the count
        return 1 + maxLength;
    }
}
