

import java.util.Scanner;

public class CommentRemover {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваш код:");
        StringBuilder code = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            code.append(line).append("\n");
        }
        scanner.close();

        String cleanedCode = removeComments(code.toString());
        System.out.println("Код без комментариев:");
        System.out.println(cleanedCode);
    }

    public static String removeComments(String code) {
        StringBuilder cleanedCode = new StringBuilder();
        boolean inBlockComment = false;
        boolean inLineComment = false;
        boolean inString = false;
        char prevChar = '\0';

        for (int i = 0; i < code.length(); i++) {
            char currentChar = code.charAt(i);

            if (inBlockComment) {
                if (currentChar == '*' && i + 1 < code.length() && code.charAt(i + 1) == '/') {
                    inBlockComment = false;
                    i++; // Skip the next character
                }
            } else if (inLineComment) {
                if (currentChar == '\n') {
                    inLineComment = false;
                }
            } else if (inString) {
                cleanedCode.append(currentChar);
                if (currentChar == '"' && prevChar != '\\') {
                    inString = false;
                }
            } else {
                if (currentChar == '/' && i + 1 < code.length()) {
                    char nextChar = code.charAt(i + 1);
                    if (nextChar == '/') {
                        inLineComment = true;
                        i++; // Skip the next character
                    } else if (nextChar == '*') {
                        inBlockComment = true;
                        i++; // Skip the next character
                    } else {
                        cleanedCode.append(currentChar);
                    }
                } else if (currentChar == '"') {
                    inString = true;
                    cleanedCode.append(currentChar);
                } else {
                    cleanedCode.append(currentChar);
                }
            }

            prevChar = currentChar;
        }

        return cleanedCode.toString();
    }
}
