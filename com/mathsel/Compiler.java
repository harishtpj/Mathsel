package com.mathsel;

import java.util.ArrayList;
import java.util.Arrays;

public class Compiler {
    

    public static String Compile(String[] progstmt){
        String cprog = "";
        ArrayList<String> vars = VarTools.VarsList();


        for (String stmt : progstmt) {
            String[] elems = stmt.split(" ");
            if (elems[0].equals("print")){
                String str = String.join(" ", Arrays.copyOfRange(elems, 1, elems.length));
                cprog += String.format("printf(%s);\n", str);
                
            } else if (elems[0].equals("println")){
                String str = String.join(" ", Arrays.copyOfRange(elems, 1, elems.length));
                cprog += String.format("printf(%s);\n", str);
                cprog += String.format("printf(\"\\n\");\n", elems[1]);

            } else if (elems[0].equals("set") && (elems[2].equals("to"))){
                if (vars.contains(elems[1])){
                    cprog += String.format("%s=%s;\n", elems[1], elems[3]);
                }

            } else if (elems[0].equals("input") && (elems[1].equals("to"))){
                if (vars.contains(elems[2])){
                    if (elems[2].startsWith("i")){
                        cprog += String.format("scanf(\"%%d\", &%s);\n", elems[2]);
                    } else if (elems[2].startsWith("d")){
                        cprog += String.format("scanf(\"%%lf\", &%s);\n", elems[2]);
                    } else if (elems[2].startsWith("c")){
                        cprog += String.format("scanf(\"%%[^\n]%%*c\", %s);\n", elems[2]);
                    }
                }
            }
        }
        return cprog;
    }
}
