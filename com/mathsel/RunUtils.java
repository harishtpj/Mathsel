package com.mathsel;

import java.io.IOException;

public class RunUtils {
    public static Process RunCommand(String cmd){
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
          }
        return process;
    }

    public static void RunProgram(String progname){
        RunCommand(String.format("tcc %s.c", progname));
    }
}
