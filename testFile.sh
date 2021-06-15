#!/bin/bash

# Execute the openjml release version to test the file supplied to the script
#
# NOTICE: this script, in its current implementation, must be kept one level above
# the openjml.jar file and the openjml.jar must be in the "openjml" subdirectory.

if [ $# -eq 0 ]; then
  echo "Specify file you wish to test"
  exit 0
fi

java -jar openjml/openjml.jar $1 -esc -verboseness 2
