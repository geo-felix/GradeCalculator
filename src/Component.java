import java.util.Arrays;
public class Component  {
    public Object[] computeMajorComponent(final String projectString, final String commaSeparatedLevel6) {
        double project = parsePercent(projectString.trim());
        double[] level6 = parseValue(commaSeparatedLevel6, 4);
        double value = Math.round(((project * 2) + level6[3] + level6[2]) / 4);
        String explanation = "Rounded average of the double-weighted project mark plus best two level 6 taught module marks.\n(project " + project + " * 2 + " + level6[3] + " + " + level6[2] +") / 4 = " + value;
        double[] remaining = new double[] { level6[0], level6[1]};
        return new Object[] { value, explanation, remaining };
        }

    public Object[] computeMinorComponent(final String commaSeparatedLevel5, final double[] remaining) {
        double[] level5 = parseValue(commaSeparatedLevel5, 6);

        final double[] modules = new double[8];
        System.arraycopy(level5, 0, modules, 0, level5.length);
        System.arraycopy(remaining, 0, modules, 6, remaining.length);
        Arrays.sort(modules);
        final StringBuilder builder = new StringBuilder();
        builder.append("Level 5 module marks: ");
        builder.append(Arrays.toString(level5));
        builder.append("\nRemaining Level 6 module marks: ");
        builder.append(Arrays.toString(remaining));
        builder.append("\nBest six marks of these: ");
        builder.append(Arrays.toString(Arrays.copyOfRange(modules, 2, 8)));
        builder.append("\nRounded average of best: ");

        double minor = 0;
        // best six marks of eight
        for (int i = 2; i < modules.length; i++) {
        minor += modules[i];
        }
        minor = Math.round(minor / 6);

        builder.append(minor);

        double value = minor;
        String explanation = builder.toString();

        return new Object[] { value, explanation };
        }

    /**
 * Splits String s on commas and converts the resulting fragments into double values.
 * Returns an array of double values. If the string does not have a number of fragments
 * equal to requiredLength, this throws an exception. If any of the values is less than
 * zero or greater than 100 an exception results. If any of the fragments is not a number
 * at all an exception results.
 *
 * @param s
 * @param requiredLength
 * @return
 */
    private  double[] parseValue(final String s, final int requiredLength) {
        final String[] fragments = s.split(",");
        if (fragments.length != requiredLength) {
        throw new IllegalArgumentException("Required " + requiredLength + " module marks, got: '" + s + "'.");
        }
        final double[] result = new double[fragments.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = parsePercent(fragments[i]);
        }
        Arrays.sort(result);
        return result;
        }

/**
 * Attempts to convert String s into a double value between 0 and 100.
 * If s does not represent a number or the number is not in this range, an exception results.
 *
 * @param
 * @return
 */
    private double parsePercent(final String s) {
        final double result = Double.valueOf(s);
        if ((result < 0) || (result > 100)) {
        throw new IllegalArgumentException("Bad mark value: " + result);
        }
        return result;
    }
}