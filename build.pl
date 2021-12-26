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
    system "javac Mathsel.java";
    system "java Mathsel test_files\\hello.me";
}

sub cdel {
    unlink "test_files\\hello.c";
    unlink "test_files\\hello.exe";
    say "Cleaned File System by deleting files";
}

unless (caller){
    shift->(@ARGV);
}