package com.company;

import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please type in any word to see if it is a Java keyword or not: ");
        String userInput = scan.nextLine();

        switch (userInput) {
            case "abstract":
            case "boolean":
            case "break":
            case "byte":
            case "case":
            case "catch":
            case "char":
            case "class":
            case "const":
            case "continue":
            case "default":
            case "do":
            case "double":
            case "else":
            case "extends":
            case "final":
            case "finally":
            case "float":
            case "for":
            case "goto":
            case "if":
            case "implements":
            case "import":
            case "instanceof":
            case "int":
            case "interface":
            case "long":
            case "native":
            case "new":
            case "null":
            case "package":
            case "private":
            case "protected":
            case "public":
            case "return":
            case "short":
            case "static":
            case "super":
            case "switch":
            case "synchronized":
            case "this":
            case "throw":
            case "throws":
            case "transient":
            case "try":
            case "void":
            case "volatile":
            case "while":
            case "assert":
            case "enum":
            case "strictfp":
                System.out.println("OOPS! This is a Java keyword.");
                break;
            default:
                System.out.println(("This is NOT a Java keyword. Woohoo!"));
        }
    }
}
