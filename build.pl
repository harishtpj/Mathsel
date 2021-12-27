# Build Script for Mathsel Compiler Project
use File::Copy;
use v5.10;
use warnings;

sub clean {
    move("hello.c", "test_files\\hello.c") or die "move failed: $!";
    move("hello.exe", "test_files\\hello.exe") or die "move failed: $!";
    say "Cleaned File System";
}

sub run {
    system "javac -cp \"\%CLASSPATH\%;lib\\commons-cli-1.5.0.jar\" Mathsel.java";
    system "java -cp \"\%CLASSPATH\%;lib\\commons-cli-1.5.0.jar\" Mathsel -r test_files\\hello.me";
}

sub cdel {
    unlink "test_files\\hello.c";
    unlink "test_files\\hello.exe";
    say "Cleaned File System by deleting files";
}

sub fresh {
    unlink "hello.c";
    unlink "hello.exe";
    say "Cleaned File System by deleting files";
}

sub compile {
    system "javac -cp \"\%CLASSPATH\%;lib\\commons-cli-1.5.0.jar\" Mathsel.java";
}

sub runonly {
    system "java -cp \"\%CLASSPATH\%;lib\\commons-cli-1.5.0.jar\" Mathsel";
}

unless (caller){
    shift->(@ARGV);
}