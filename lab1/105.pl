#!/usr/bin/perl

while ($line = <>) {
    if (lc ($line)  =~ /[x|y|z](.{5,17})[x|y|z]/) {
        print $line;
    }
}