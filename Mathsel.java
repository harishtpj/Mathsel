// MathSEL - Math based Statement Expression Language

// Imports
import org.apache.commons.cli.*;


// Compiler Imports
import com.mathsel.Compiler;
import com.mathsel.FileUtils;
import com.mathsel.Template;
import com.mathsel.Tools;
import com.mathsel.Meta;


class Mathsel {

    public static void Run(String fname){
        // Basic Variable Initialisation
        String filename = Tools.ProgName(fname);
        String compiled_program = Template.program_template;
        String program = FileUtils.ReadFile(fname);

        // Main Transformation
        String[] progstmt = Tools.PrepareForCompile(program);
        compiled_program += Compiler.Compile(progstmt) + "return 0;\n}";
        FileUtils.WriteFile(compiled_program, filename + ".c");
        Tools.RunProgram(filename);
    }

    public static void main(String[] args) throws ParseException{
        // CLI Interface
        Options options = new Options();
        CommandLine cmd;
        CommandLineParser parser = new DefaultParser();
        HelpFormatter helper = new HelpFormatter();

        options.addOption("r", "run", true, "Run Program");
        options.addOption("h", "help", false, "Shows Help Message");
        options.addOption("v", "version", false, "Shows Version");
        
        try {
            cmd = parser.parse(options, args);
            if (cmd.hasOption("r")) {
                String fname = cmd.getOptionValue("run");
                Run(fname);
            }
            if (cmd.hasOption("h")) {
                Meta.HelpMsg(helper, options);
            }
            if (cmd.hasOption("v")) {
                System.out.printf("This is Mathsel v%s - The Math Statement Language\n", Meta.version);
                System.out.printf("Created by %s\n", Meta.author);
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            Meta.HelpMsg(helper, options);
        }
    }
}