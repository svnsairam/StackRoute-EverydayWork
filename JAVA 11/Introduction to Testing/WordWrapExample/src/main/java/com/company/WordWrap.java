package com.company;

public class WordWrap {


    public static String wrap(String inputLine, int lineLength) {

        StringBuilder sb = new StringBuilder();


        sb.append(inputLine, 0, Math.min(lineLength, inputLine.length()));
        int split = lineLength;
        int length =  inputLine.length();


        while(length > split){
            sb.append('\n');
            sb.append(inputLine,split,Math.min(length, split+lineLength));
            split = split + lineLength;
        }

        return sb.toString();
    }
}
