#!/usr/bin/perl

while ($line = <>) {
    if (lc ($line)  =~ /z(.{3})z/) {
        print $line;
    }
}