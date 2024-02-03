#!/usr/bin/perl

while (<>) {
    s/\b([A|a]+)\b/argh/;
    print;
}