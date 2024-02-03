#!/usr/bin/perl


while ($line = <>) {
    if (($line =~ /^$/) || (($line) =~ /^[^\s+]/ && ($line) =~ /[^\s+]$/)) {
        print $line;
    }
}