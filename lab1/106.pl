#!/usr/bin/perl

while ($line = <>) {
    if (($line)  =~ /\b[0-9]+\b/) {
        print $line;
    }
}