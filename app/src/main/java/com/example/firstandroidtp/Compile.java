package com.example.firstandroidtp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class Compile {

    private String tableau[][] = new String[][]{
            //       +      , -      , *      , /      , (     , )     , ?      , i     , #
            {null, "CB", null, null, "CB", null, "CB", "CB", null}, /*A*/
            {"+CaB", "-CbB", null, null, null, "", null, "", ""}, /*B*/
            {null, "ED", null, null, "ED", null, "ED", "ED", null}, /*C*/
            {"", "", "*EcD", "/EdD", null, "", null, "", ""}, /*D*/
            {null, "-Ee", null, null, "F", null, "F", "F", null}, /*E*/
            {null, null, null, null, "(A)f", null, "?(A)g", "i", null} /*F*/};
    //
//    private String tableau[][] = new String[][]{
//        //+,-,*,/,(,),i,#
//        {null, "CB", null, null, "CB", null, "CB", "CB", null},
//        {"+CaB", "-CsB", null, null, null, "", null, "", ""},
//        {null, "ED", null, null, "ED", null, "ED", "ED", null},
//        {"", "", "*EmD", "/EdD", null, "", null, "", ""},
//        {null, "-Eu", null, null, "F", null, "F", "F", null},
//        {null, null, null, null, "(A)p", null, "?(A)f", "i", null}
//    };
    private String terminaux = "+-*/()?i#";
    private Stack<Double> pileValeur;
    private Stack<String> pileFonction;

    public Double analyseur(String entrée) throws Exception {
        Lex lex = new Lex(entrée);
        Stack<Character> pile = new Stack<Character>();
        pileFonction = new Stack<String>();
        pileValeur = new Stack<Double>();
        pile.push('#');
        pile.push('A');
        char tc = lex.nextToken();
        char sommet = pile.peek();
        while (!pile.empty()) {
            sommet = pile.peek();
            if (sommet == tc) {
                if (tc == 'i'){
                    pileValeur.push(lex.getVal());
                }else{
                    if (tc == '?'){
                        pileFonction.push(lex.getFonction());
                    }
                }
                tc = lex.nextToken();
                pile.pop();
            } else {
                if (sommet >= 'a') {
                    pile.pop();
                    calculer(sommet - 'a');
                } else {
                    int col = terminaux.indexOf(tc);
                    int lig = sommet - 'A';
                    pile.pop();
                    String mdp = tableau[lig][col];
                    if (mdp == null) {
                        throw new Exception();
                    }
                    for (int i = mdp.length() - 1; i >= 0; i--) {
                        pile.push(mdp.charAt(i));
                    }
                }
            }
        }
        return pileValeur.pop();
    }

    private void calculer(int i) throws Exception {
        switch (i) {
            case 0: {
                double v2 = pileValeur.pop();
                double v1 = pileValeur.pop();
                pileValeur.push(v1+v2);
                break;
            }
            case 1: {
                double v2 = pileValeur.pop();
                double v1 = pileValeur.pop();
                pileValeur.push(v1-v2);
                break;
            }
            case 2: {
                double v2 = pileValeur.pop();
                double v1 = pileValeur.pop();
                pileValeur.push(v1*v2);
                break;
            }
            case 3: {
                double v2 = pileValeur.pop();
                double v1 = pileValeur.pop();
                pileValeur.push(v1/v2);
                break;
            }
            case 4: {
                double v1 = pileValeur.pop();
                pileValeur.push(-v1);
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                double v1 = pileValeur.pop();
                pileValeur.push(fonction(pileFonction.pop(),v1));
                break;
            }
        }
    }

    private Double fonction(String ftc, double val) throws Exception{
        if (ftc.equalsIgnoreCase("log")) return Math.log(val);
        if (ftc.equalsIgnoreCase("cos")) return Math.cos(val);
        if (ftc.equalsIgnoreCase("sin")) return Math.sin(val);
        if (ftc.equalsIgnoreCase("sqrt")) return Math.sqrt(val);
        throw new Exception();
    }
}