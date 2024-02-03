#!/usr/bin/perl

while (<>) {
    s/([a-z])\g1+/$1/g;
    print;
}