package com.mathsel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUtils {
    public static String OpenFile(String fname){
        String p = "";
        try {
            File prog = new File(fname);
            Scanner myReader = new Scanner(prog);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                p += data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("mathsel: compilation error: Cannot Open File");
            System.exit(0);
        }
        return p;
    }

    public static void WriteFile(String c_program, String progname) {
        try {
            FileWriter myWriter = new FileWriter(progname);
            myWriter.write(c_program);
            myWriter.close();
          } catch (IOException e) {
            System.out.println("mathsel: compilation error: Cannot Write File");
            System.exit(0);
          }
    }

    public static String ReadFile(String fname){
        String program = "";
        program = OpenFile(fname);
        return program;
    }
}
