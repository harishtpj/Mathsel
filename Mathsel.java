// MathSEL - Math based Statement Expression Language

// Imports



// Compiler Imports
import com.mathsel.Compiler;
import com.mathsel.FileUtils;
import com.mathsel.Template;
import com.mathsel.Tools;


class Mathsel {

    public static void main(String[] args) {
        // Basic Variable Initialisation
        String fname = args[0];
        String filename = Tools.ProgName(fname);
        String compiled_program = Template.program_template;
        String program = FileUtils.ReadFile(fname);

        // Main Transformation
        String[] progstmt = Tools.PrepareForCompile(program);
        compiled_program += Compiler.Compile(progstmt) + "return 0;\n}";
        FileUtils.WriteFile(compiled_program, filename + ".c");
        Tools.RunProgram(filename);
    }
}