#!/usr/bin/perl


while ($line = <>) {
    if ($line =~ '\b(\w+)\g1\b') {
        print $line;
    }
}