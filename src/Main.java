import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(final String[] args) throws IOException {

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter final year project mark: ");
        final String projectMark = in.readLine();
        System.out.print("Enter four level 6 taught module marks separated by commas: ");
        final String level6Marks = in.readLine();
        Component majorComponent= new Component();
        final Object[] major = majorComponent.computeMajorComponent(projectMark, level6Marks);
        System.out.print("Enter six level 5 taught module marks separated by commas: ");
        final String level5Marks = in.readLine();
        Component minorComponent= new Component();
        final Object[] minor = minorComponent.computeMinorComponent(level5Marks, (double[]) major[2]);
        FinalGrade overallComponent= new FinalGrade();
        final Object[] overall = overallComponent.computeOverallMark((Double) major[0], (Double) minor[0], (String) major[1], (String) minor[1]);
        System.out.println(overall[1]);
    }
}

