package com.doney.advanced.log;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    private static final Pattern cardNoRegEx = Pattern.compile("[^0-9]");
    public static void main(String[] args) {
        String a="love23next234csdn3423javaeye";
        String b="************8824";
        String c="************null";
        String d="Edit the Expression & Text to see matches. Roll over matches or the expression for details. Undo mistakes with {{ctrl}}-z. Save Favorites & Share expressions with friends or the Community. Explore your results with Tools. A full Reference & Help is available in the Library, or watch the video Tutorial.\n" +
                "\n" +
                "Sample text for testing:\n" +
                "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ\n" +
                "0123456789 _+-.,!@#$%^&*();\\/|<>\"'\n" +
                "12345 -98.7 3.141 .6180 9,000 +42\n" +
                "555.123.4567\t+1-(800)-555-2468\n" +
                "foo@demo.net\tbar.ba@test.co.uk\n" +
                "www.kgraph.cn\tkgraph_bigdata\n" +
                "http://www.kgraph.cn/?s=bar";

        Matcher m = cardNoRegEx.matcher(d);
        String group = m.group();

    }
}
