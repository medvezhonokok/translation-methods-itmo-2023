#!/usr/bin/perl

while (<>) {
    s/a.*?aa.*?aa.*?a/bad/g;
    print;
}