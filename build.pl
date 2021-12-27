# Build Script for Mathsel Compiler Project
use File::Copy;
use v5.10;
use warnings;
use strict "vars";

sub clean {
    my $filename = $_[1];
    move("$filename.c", "test_files\\$filename.c") or die "move failed: $!";
    move("$filename.exe", "test_files\\$filename.exe") or die "move failed: $!";
    say "Cleaned File System";
}

sub run {
    my $filename = $_[1];
    system "javac -cp \"\%CLASSPATH\%;lib\\commons-cli-1.5.0.jar\" Mathsel.java";
    system "java -cp \"\%CLASSPATH\%;lib\\commons-cli-1.5.0.jar\" Mathsel -r $filename";
}

sub fresh {
    my $filename = $_[1];
    unlink "$filename.c";
    unlink "$filename.exe";
    say "Cleaned File System by deleting files";
}

sub compile {
    system "javac -cp \"\%CLASSPATH\%;lib\\commons-cli-1.5.0.jar\" Mathsel.java";
}

sub runonly {
    my $flags = $_[1];
    system "java -cp \"\%CLASSPATH\%;lib\\commons-cli-1.5.0.jar\" Mathsel $flags";
}

unless (caller){
    shift->(@ARGV);
}