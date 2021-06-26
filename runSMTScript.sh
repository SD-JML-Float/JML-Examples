#!/bin/bash

# Script to run SMT script in latest version of z3

# ensure file argument was passed in
if [ $# != 1 ]; then
  echo "Please supply name of script you wish to execute"
  exit 0
fi

# ensure file passed exists
if [ ! -f "$1" ]; then
  echo "File supplied does not exist"
  exit 0
fi

./openjml/Solvers-linux/z3-4.7.1 $1
