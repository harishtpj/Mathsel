package com.mathsel;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import com.mathsel.errors.CompilerError;
import com.mathsel.errors.RuntimeError;

public class Tools {
    public static Process RunCommand(String cmd){
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
            String line;

            // STDOUT
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            // STDERR
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.out.println(line);
            }
            errorReader.close();
            
        } catch (IOException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            
            String errmsg = "Insufficient tools to compile program\n"
                          + "Java Error Stack Trace:\n"
                          + sw.toString();

            Tools.ThrowError(new CompilerError("NoToolError", errmsg));
          }
        return process;
    }

    public static void RunProgram(String progname){
        RunCommand(String.format("tcc %s.c", progname));
    }

    public static String ProgName(String fname){
        File f = new File(fname);
        fname = f.getName();
        return (fname == null || fname.length() == 0)
        ? null
        : (fname.substring(0, fname.length() - 3));
    }

    public static String[] PrepareForCompile(String program){
        program = program.replace("\n", "");
        program = program.replace("\t", "");
        return program.split(Pattern.quote(".!"));
    }

    public static void ThrowError(CompilerError error){
        error.Run();
    }

    public static void ThrowError(RuntimeError error){
        error.Run();
    }
}
