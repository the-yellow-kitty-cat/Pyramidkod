package itello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string");
        String p = in.nextLine();
        String encryptionToString = getPyramidEncryption(p);
        System.out.println(encryptionToString);
    }

    static String getPyramidEncryption(String p) {
        String s = prepareString(p);
        List<String> pyramidList = createPyramidList(s);
        return encryptPyramid(pyramidList);
    }

    static String prepareString(String p) {
        p = p.replaceAll("[^\\p{Alnum}^åÅäÄöÖ]", "");
        p = p.toUpperCase();
        return p;
    }

    static List<String> createPyramidList(String p) {
        int nextRow = 1;
        List<String> allRows = new ArrayList<>();
        String originalP = p;
        while (p.length() > 0) {
            if (nextRow > p.length()) {
                String beginAgain = originalP.substring(0, nextRow - p.length());
                allRows.add(p + beginAgain);
                p = "";
            } else {
                String pSubstring = p.substring(0, nextRow);
                allRows.add(pSubstring);
                p = p.substring(nextRow);
            }
            nextRow++;
        }
        return allRows;
    }

    static String encryptPyramid(List<String> allRows) {
        StringBuilder encryptedPyramidString = new StringBuilder();
        int lastIndex = allRows.size() - 1;
        while (!allRows.get(lastIndex).isEmpty()) {
            for (int listIndex = lastIndex; listIndex >= 0; listIndex--) {
                String currentRow = allRows.get(listIndex);
                if (!currentRow.isEmpty()) {
                    encryptedPyramidString.append(currentRow.charAt(0));
                    allRows.set(listIndex, currentRow.substring(1));
                }
            }
        }
        return encryptedPyramidString.toString();
    }
}