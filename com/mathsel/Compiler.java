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
                    if (elems[1].startsWith("c")){
                        String str = String.join(" ", Arrays.copyOfRange(elems, 3, elems.length));
                        cprog += String.format("strcpy(%s,%s);\n", elems[1], str);
                    } else {
                        cprog += String.format("%s=%s;\n", elems[1], elems[3]);
                    }
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

            } else if (elems[0].equals("!:")){
                continue;

            } else if (elems[0].equals("incr")){
                if (vars.contains(elems[1]) && (elems[1].startsWith("i") || elems[1].startsWith("d"))){
                    cprog += String.format("++%s;\n", elems[1]);

                }
            } else if (elems[0].equals("decr")){
                if (vars.contains(elems[1]) && (elems[1].startsWith("i") || elems[1].startsWith("d"))){
                    cprog += String.format("--%s;\n", elems[1]);

                }
            } else if (elems[0].equals("add") && (elems[2].equals("to"))){
                if (vars.contains(elems[1])){
                    cprog += String.format("%s += %s;\n", elems[3], elems[1]);
                }

            } else if (elems[0].equals("subtract") && (elems[2].equals("from"))){
                if (vars.contains(elems[1])){
                    cprog += String.format("%s -= %s;\n", elems[3], elems[1]);
                }
                
            } else if (elems[0].equals("multiply") && (elems[2].equals("with"))){
                if (vars.contains(elems[1])){
                    cprog += String.format("%s *= %s;\n", elems[3], elems[1]);
                }
                
            } else if (elems[0].equals("divide") && (elems[2].equals("into"))){
                if (vars.contains(elems[1])){
                    cprog += String.format("%s /= %s;\n", elems[3], elems[1]);
                }
                
            } else if (elems[0].equals("square") && (elems[2].equals("to"))){
                if (vars.contains(elems[3])){
                    cprog += String.format("%s = pow(%s, 2.0);\n", elems[3], elems[1]);
                }

            } else if (elems[0].equals("sqrt") && (elems[2].equals("to"))){
                if (vars.contains(elems[3])){
                    cprog += String.format("%s = sqrt(%s);\n", elems[3], elems[1]);
                }

            } else if (elems[0].equals("cube") && (elems[2].equals("to"))){
                if (vars.contains(elems[3])){
                    cprog += String.format("%s = pow(%s, 3.0);\n", elems[3], elems[1]);
                }

            } else if (elems[0].equals("cbrt") && (elems[2].equals("to"))){
                if (vars.contains(elems[3])){
                    cprog += String.format("%s = pow(%s, ceil((1/3.0)*100)/100);\n", elems[3], elems[1]);
                }

            } else if (elems[0].equals("pow") && (elems[2].equals("with")) && (elems[4].equals("to"))){
                if (vars.contains(elems[5])){
                    cprog += String.format("%s = pow(%s, %s);\n", elems[5], elems[1], elems[3]);
                }

            } else if (elems[0].equals("root") && (elems[2].equals("with")) && (elems[4].equals("to"))){
                if (vars.contains(elems[5])){
                    cprog += String.format("%s = pow(%s, ceil((1.0/%s)*100)/100);\n", elems[5], elems[1], elems[3]);
                }

            } else if (elems[0].equals("clear")){
                if (vars.contains(elems[1])){
                    if (elems[1].startsWith("i")){
                        cprog += String.format("%s=0;\n", elems[1]);
                    } else if (elems[1].startsWith("d")){
                        cprog += String.format("%s=0.0;\n", elems[1]);
                    } else if (elems[1].startsWith("c")){
                        cprog += String.format("strcpy(%s, \"\");\n", elems[1]);
                    }
                }

            } else if (elems[0].equals("push") && (elems[2].equals("to"))){
                if (vars.contains(elems[1]) && ((Integer.parseInt(elems[3]) < 11) && (Integer.parseInt(elems[3]) > 0))){
                    if (elems[1].startsWith("i")){
                        cprog += String.format("isp[%s-1]=%s;\n", elems[3], elems[1]);
                        cprog += String.format("%s=0;\n", elems[1]);
                    } else if (elems[1].startsWith("d")){
                        cprog += String.format("dsp[%s-1]=%s;\n", elems[3], elems[1]);
                        cprog += String.format("%s=0.0;\n", elems[1]);
                    } else if (elems[1].startsWith("c")){
                        cprog += String.format("strcpy(csp + (%s - 1), %s);\n", elems[3], elems[1]);
                        cprog += String.format("strcpy(%s, \"\");\n", elems[1]);
                    }
                }
            } else if (elems[0].equals("get") && (elems[2].equals("from"))){
                if (vars.contains(elems[1]) && ((Integer.parseInt(elems[3]) < 11) && (Integer.parseInt(elems[3]) > 0))){
                    if (elems[1].startsWith("i")){
                        cprog += String.format("%s=isp[%s-1];\n", elems[1], elems[3]);
                        cprog += String.format("isp[%s-1]=0;\n", elems[3]);
                    } else if (elems[1].startsWith("d")){
                        cprog += String.format("%s=dsp[%s-1];\n", elems[1], elems[3]);
                        cprog += String.format("dsp[%s-1]=0.0;\n", elems[3]);
                    } else if (elems[1].startsWith("c")){
                        cprog += String.format("strcpy(%s, csp + (%s - 1));\n", elems[1], elems[3]);
                        cprog += String.format("strcpy(csp + (%s - 1), \"\");\n", elems[3]);
                    }
                }
            }
        }
        return cprog;
    }
}
