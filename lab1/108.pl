#!/usr/bin/perl


while ($line = <>) {
    if ($line =~ '\([^()]+\)' && $line !~ '\(\s+\)') {
        print $line;
    }
}