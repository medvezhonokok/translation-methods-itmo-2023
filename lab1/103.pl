#!/usr/bin/perl

while ($line = <>) {
    if (lc ($line)  =~ /cat/) {
        print $line;
    }
}