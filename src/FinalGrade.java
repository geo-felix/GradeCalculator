public class FinalGrade extends Component {
    public Object[] computeOverallMark(double major, double minor, String majorExplanation, String minorExplanation) {
        double value = Math.round((major * 0.8) + (minor * 0.2));

        final StringBuilder builder = new StringBuilder();
        builder.append("Major component calculation\n");
        builder.append(majorExplanation);
        builder.append("\nMinor component calculation\n");
        builder.append(minorExplanation);
        builder.append("\nOverall mark\nMajor component weighted 80% and minor component weighted 20%\n");
        builder.append("(major " + major + " * 0.8) + (minor " + minor + " + * 0.2) = " + value);
        String explanation = builder.toString();

        return new Object[] { value, explanation };
    }
}
