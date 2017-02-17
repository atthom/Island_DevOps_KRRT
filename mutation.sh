#!/usr/bin/env bash

mkdir mutants
rm -rf mutants/*

while read p; do
  cp -r ./AmazingExplorer mutants/$p
  rm -rf mutants/$p/target
  rm -rf mutants/$p/src/main
  cp -r ./AmazingExplorer/target/generated-sources/spoon mutants/$p/src/main
done <mutators.txt