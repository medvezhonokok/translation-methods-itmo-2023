#!/usr/bin/perl

my @origin;
my $emptyLinesCount = 0;

while (my $line = <>) {
    chomp($line);
    $line =~ s/<[^>]+>//g;

    if ($line =~ /^\s*$/ || $line =~ /\n/) {
        $emptyLinesCount++;
    }
    else {
        $emptyLinesCount = 0;
    }

    if ($emptyLinesCount <= 1) {
        $line =~ s/^\s+|\s+$//g;
        $line =~ s/\s{2,}/ /g;
        push @origin, $line;
    }
}

print join("\n", @origin) =~ s/^\s+|\s+$//gr;