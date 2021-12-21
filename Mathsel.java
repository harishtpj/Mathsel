// MathSEL - Math based Statement Expression Language

// Imports
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.regex.Pattern;


// Compiler Imports
import com.mathsel.Compiler;
import com.mathsel.FileUtils;
import com.mathsel.RunUtils;


class Mathsel {

    public static void main(String[] args) {
        String program = "";

        //Template C Code
        String compiled_program = "#include <stdio.h>\n"
                                + "int main(){\n";




        try {
            program = FileUtils.OpenFile(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("mathsel: compilation error: No File Supplied");
            System.exit(0);
        }

        program = program.replace("\n", "");
        program = program.replace("\t", "");
        String[] progstmt = program.split(Pattern.quote("."));
        compiled_program += Compiler.Compile(progstmt);
        compiled_program += "return 0;\n}";
        FileUtils.WriteFile(compiled_program, "hello.c");
        RunUtils.RunProgram("hello");
    }
}