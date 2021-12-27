package com.mathsel;

import org.apache.commons.cli.*;

public class Meta {
    // Meta Variables
    public static String version = "1.0";
    public static String author = "M.V.Harish Kumar";


    public static void HelpMsg(HelpFormatter helper, Options options){
        helper.printHelp("mathsel [options]", options);
        System.exit(0);
    }
}
