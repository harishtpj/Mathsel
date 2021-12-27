package com.mathsel.errors;

public class RuntimeError {
    private String errname;
    private String errmsg;
    private String errstmt;
    private int lineno;

    public RuntimeError(String errname, String errmsg, String errstmt, int lineno){
        this.errname = errname;
        this.errmsg = errmsg;
        this.errstmt = errstmt;
        this.lineno = lineno;
    }

    public void Run(){
        System.out.println("Mathsel - Runtime Error");
        System.out.printf("In Statement %d:\n", lineno);
        System.out.printf("\t%s\n", errstmt);
        System.out.printf("%s : %s\n", errname, errmsg);
        System.exit(0);
    }
}
