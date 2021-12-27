package com.mathsel.errors;

public class CompilerError {
    private String errname;
    private String errmsg;

    public CompilerError(String errname, String errmsg){
        this.errname = errname;
        this.errmsg = errmsg;
    }

    public void Run(){
        System.out.println("Mathsel - Compile Time Error:");
        System.out.printf("\t%s : %s\n", errname, errmsg);
        System.exit(0);
    }
}
