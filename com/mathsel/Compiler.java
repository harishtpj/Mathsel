package com.mathsel;

import java.util.Arrays;

public class Compiler {
    public static String Compile(String[] progstmt){
        String cprog = "";
        for (String stmt : progstmt) {
            String[] elems = stmt.split(" ");
            if (elems[0].equals("print")){
                String str = String.join(" ", Arrays.copyOfRange(elems, 1, elems.length));
                cprog += String.format("printf(%s);\n", str);
                
            } else if (elems[0].equals("println")){
                String str = String.join(" ", Arrays.copyOfRange(elems, 1, elems.length));
                cprog += String.format("printf(%s);\n", str);
                cprog += String.format("printf(\"\\n\");\n", elems[1]);
            }
        }
        return cprog;
    }
}
