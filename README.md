# 🔢 Mathsel 
[![made-with-java](https://img.shields.io/badge/Made%20with-Java-orange?&logo=java&logoColor=white)](https://www.oracle.com/in/java/)
[![java-version](https://img.shields.io/badge/Java-v16.0.1-orange)](https://www.ruby-lang.org)

A Math Statement Based Language which compiles its code to C Language

# ℹ About Mathsel
Mathsel is a C Transpiler(Compiler) written in Java which Compiles to C Language. This has a very 
simple syntax which can also be used as C alternative to Very small programs.

# 📃 Requirements
- Java JDK
- tcc compiler(click [here](https://bellard.org/tcc/) for link)

# 💻 Running the compiler
Use command ```java -jar Mathsel.jar``` to run compiler
```
usage: mathsel [options]
 -h,--help        Shows Help Message
 -r,--run <arg>   Run Program
 -v,--version     Shows Version
```
# A Sample Hello, World Program
Save the following file as hello.me
``` c
println "Hello, World!".!
```
Run ```java -jar Mathsel.jar -r hello.me ``` to get the executable for program. Run the executable to get the output of the program. You'll also get a ```hello.c``` file for inspection.

# 👨‍💻 Created By
- ## M.V.Harish Kumar
