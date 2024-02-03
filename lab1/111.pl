#!/usr/bin/perl


while ($line = <>) {
    if ($line =~ /^(1(01*0)*1|0)+$/) {
        print $line;
    }
}