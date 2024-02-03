#!/usr/bin/perl

while ($line = <>) {
    if (($line)  =~ /\\/) {
        print $line;
    }
}