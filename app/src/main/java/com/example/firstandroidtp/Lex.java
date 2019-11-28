package com.example.firstandroidtp;

/**
 *
 * @author client
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lex {

    private final Pattern nombre = Pattern.compile("\\d+(\\.\\d+)?");
    private final Pattern fonction = Pattern.compile("log|cos|sin|sqrt");
    private int pos;
    private double value;
    private String fct;
    private String s;

    public Lex(String str) {
        s = str;
        pos = 0;
        value = 0.0;
    }

    public String getFonction() {
        return fct;
    }

    public double  getVal() {
        return value;
    }

    public char nextToken() throws Exception { //fonction qui retourne la prochaine entite lexicale
        if (pos == s.length()) //si chaine est lu entierement retourner #
        {
            return '#';
        }
        Matcher entM = nombre.matcher(s.substring(pos));//si c est un entier
        if (entM.lookingAt()) {
            value = Double.parseDouble(entM.group());
            pos += entM.group().length();
            return 'i';
        }
        Matcher fonct = fonction.matcher(s.substring(pos));//si c'est une fonction
        if (fonct.lookingAt()) {
            fct = fonct.group();
            pos += fonct.group().length();
            return '?';
        }
        char c = s.charAt(pos++);
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') //entitee reconnue
        {
            return c;
        }
        throw new Exception();
    }
}