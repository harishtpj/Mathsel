// MathSEL - Math based Statement Expression Language
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.IOException;


class Mathsel {
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

    public static String Compile(String[] progstmt){
        String cprog = "";
        for (String stmt : progstmt) {
            String[] elems = stmt.split(" ");
            if (elems[0].equals("print")){
                cprog += String.format("printf(%s);\n", elems[1]);
            } else if (elems[0].equals("println")){
                cprog += String.format("printf(%s);\n", elems[1]);
                cprog += String.format("printf(\"\\n\");\n", elems[1]);
            }
        }
        return cprog;
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

    public static void main(String[] args) {
        String program = "";

        //Template C Code
        String compiled_program = "#include <stdio.h>\n"
                                + "int main(){\n";




        try {
            program = OpenFile(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("mathsel: compilation error: No File Supplied");
            System.exit(0);
        }

        program = program.replace("\n", "");
        program = program.replace("\t", "");
        String[] progstmt = program.split(Pattern.quote("."));
        compiled_program += Compile(progstmt);
        compiled_program += "return 0;\n}";
        WriteFile(compiled_program, "hello.c");
        RunProgram("hello");
    }
}