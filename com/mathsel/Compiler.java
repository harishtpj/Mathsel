package com.mathsel;

public class Compiler {
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
}
