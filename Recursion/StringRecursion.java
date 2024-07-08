import java.util.ArrayList;

public class StringRecursion {
    public static void main(String[] args) {
        String str = "ansh roshan is alpaha male.";
        System.out.println("Modified -> " + stringSkip(str, 'a'));
        System.out.println("Modified -> " + stringSkipStr(str, "an"));
        System.out.println("Modified -> " + stringSkipStrCond(str, "an", "ansh"));
        str = "ansh";
        System.out.println("The subsets are :-" + subsetCreator(str));
        System.out.println("The subsets are :-" + generateSubsetsAL(str, ""));
        System.out.println("The subsets are :-" + generateSubsetsALSCII(str, ""));

    }

    static String stringSkip(String str, char ch) {
        if (str.isEmpty())
            return "";

        char fchar = str.charAt(0);
        if (fchar != ch)
            return fchar + stringSkip(str.substring(1), ch);

        else
            return stringSkip(str.substring(1), ch);

    }

    static String stringSkipStr(String str, String target) {
        if (str.length() < target.length())
            return "";

        String temp = str.substring(0, target.length());
        if (temp.startsWith(target))
            return stringSkipStr(str.substring(target.length()), target);

        else
            return temp.charAt(0) + stringSkipStr(str.substring(1), target);

    }

    static String stringSkipStrCond(String str, String target, String leave) {
        if (str.length() < target.length())
            return "";
        String temp = str.substring(0, target.length());
        if (temp.startsWith(target) && !temp.startsWith(leave))
            return stringSkipStrCond(str.substring(target.length()), target, leave);

        else
            return temp.charAt(0) + stringSkipStrCond(str.substring(1), target, leave);

    }

    static ArrayList<String> subsetCreator(String str) {
        ArrayList<String> subsets = new ArrayList<String>();
        generateSubsets(str, "", subsets);
        return subsets;
    }

    private static void generateSubsets(String str, String current, ArrayList<String> subsets) {
        if (str.isEmpty()) {
            subsets.add(current);
            return;
        }
        char ch = str.charAt(0);
        generateSubsets(str.substring(1), current + ch, subsets);
        generateSubsets(str.substring(1), current, subsets);
    }

    static ArrayList<String> generateSubsetsAL(String str, String current) {
        ArrayList<String> subsets = new ArrayList<String>();
        if (str.isEmpty()) {
            subsets.add(current);
            return subsets;
        }
        char ch = str.charAt(0);
        subsets.addAll(generateSubsetsAL(str.substring(1), current + ch));
        subsets.addAll(generateSubsetsAL(str.substring(1), current));
        return subsets;
    }

    static ArrayList<String> generateSubsetsALSCII(String str, String current) {
        ArrayList<String> subsets = new ArrayList<String>();
        if (str.isEmpty()) {
            subsets.add(current);
            return subsets;
        }
        char ch = str.charAt(0);
        subsets.addAll(generateSubsetsALSCII(str.substring(1), current + ch));
        subsets.addAll(generateSubsetsALSCII(str.substring(1), current + (ch + 0)));
        subsets.addAll(generateSubsetsALSCII(str.substring(1), current));
        return subsets;
    }

}
