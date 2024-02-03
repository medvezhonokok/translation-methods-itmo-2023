#!/usr/bin/perl

while ($line = <>) {
    if (($line)  =~ /\bcat\b/) {
        print $line;
    }
}