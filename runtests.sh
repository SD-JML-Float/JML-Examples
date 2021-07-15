#!/bin/bash


# Test Script
# requires timelimit
# can be installed on ubuntu via suda apt install timelimit


# basically, for each folder (primitives, Double, Float, and Math) this bash script does the following:
# 1. uses javac to compile each .java file
# 2. uses javap to generate a list of the methods in the .class file
# 3. for each method in .class file: runs method and gets program output

# output text coloring constants
TEXT_GREEN="\033[0;32m"
TEXT_LIGHT_BLUE="\033[1;34m"
TEXT_NO_COLOR="\033[0m"
TEXT_LIGHT_PURPLE="\033[1;35m"
TEXT_RED="\033[0;31m"
TEXT_YELLOW="\033[1;33m"


# timelimit that we let OpenJML run for on a given method
timelimit=8

# boolean, do we test primitive test files?
testPrimitives=true

# boolean, do we test Double test files?
testDouble=false

# boolean, do we test Float test files?
testFloat=false

# boolean, do we test Math test files?
testMath=false

# counters to keep track of test case results (valid, invalid, error, hang)
valid=0
invalid=0
error=0
hang=0


# test primitives here
if $testPrimitives ; then

printf "${TEXT_LIGHT_PURPLE}%s${TEXT_NO_COLOR}\n" "Primitives"
for filename in PrimitiveOps/*.java; do
	javac $filename
	printf "${TEXT_LIGHT_BLUE}  %s${TEXT_NO_COLOR}\n" "${filename}"


	classname=${filename%.java}
	classname="${classname}.class"

	methods=$(javap $classname)

	i=0
	end="}"
	while IFS= read -r line; do
		((i++))

		if (( $i > 3 )) && ! [  $end = "$line" ] ; then
			edited=${line%(*}
			IFS=' '
			read -a strarr <<< "$edited"
			method=${strarr[-1]}

			timelimit -t$timelimit java -jar openjml/openjml.jar -esc -method $method -verboseness 2 $filename > out.txt 2>&1

			if grep -q "timelimit:" "out.txt"; then
				printf "    %-30s ${TEXT_RED}%s${TEXT_NO_COLOR}\n" "$method" "invalid - timeout"
				((hang++))

			elif ! grep -q "Error:        0" "out.txt"; then
				printf "    %-30s ${TEXT_RED}%s${TEXT_NO_COLOR}\n" "$method" "error"
				((error++))

			elif ! grep -q "Invalid:      0" "out.txt"; then
				printf "    %-30s ${TEXT_RED}%s${TEXT_NO_COLOR}\n" "$method" "invalid"
				((invalid++))

			elif ! grep -q "Infeasible:   0" "out.txt"; then
				printf "    %-30s ${TEXT_RED}%s${TEXT_NO_COLOR}\n" "$method" "infeasible"
				((infeasible++))

			else
				printf "    %-30s ${TEXT_GREEN}%s${TEXT_NO_COLOR}\n" "$method" "valid"
				((valid++))
			fi

		fi
	done <<< "$methods"

done



total_valid=$valid
total_invalid=$invalid
total_hang=$hang
total_infeasible=$infeasible
total_error=$error

printf '\nPrimitives Results:\n\tTotal Valid:%-22s\n\tTotal Invalid:%-22s\n\tTotal Infeasible:%-22s\n\tTotal Errors:%-22s\n\tTotal Hanged:%-22s\n\n\n' "$valid" "$invalid" "$infeasible" "$error" "$hang"
fi

valid=0
invalid=0
hang=0
infeasible=0
error=0



# test Double here
if $testDouble ; then

printf "${TEXT_LIGHT_PURPLE}  %s${TEXT_NO_COLOR}\n" "Double"
for filename in Double/*.java; do
	javac $filename
	echo -e "\t$filename"


	classname=${filename%.java}
	classname="${classname}.class"

	methods=$(javap $classname)

	i=0
	end="}"
	while IFS= read -r line; do
		((i++))

		if (( $i > 3 )) && ! [  $end = "$line" ] ; then
			edited=${line%(*}
			IFS=' '
			read -a strarr <<< "$edited"
			method=${strarr[-1]}

			timelimit -t$timelimit java -jar openjml/openjml.jar -esc -method $method -verboseness 2 $filename > out.txt 2>&1

			if grep -q "timelimit:" "out.txt"; then
				printf '    %-30s %s\n' "$method" "hanged"
				((hang++))

			elif ! grep -q "Error:        0" "out.txt"; then
				printf '    %-30s %s\n' "$method" "error"
				((error++))

			elif ! grep -q "Invalid:      0" "out.txt"; then
				printf '    %-30s %s\n' "$method" "invalid"
				((invalid++))

			elif ! grep -q "Infeasible:   0" "out.txt"; then
				printf '    %-30s %s\n' "$method" "infeasible"
				((infeasible++))

			else
				printf '    %-30s %s\n' "$method" "valid"
				((valid++))
			fi

		fi
	done <<< "$methods"

done



((total_valid+=$valid))
((total_invalid+=$invalid))
((total_hang+=$hang))
((total_infeasible+=$infeasible))
((total_error+=$error))

printf '\nPrimitives Results:\n\tTotal Valid:%-22s\n\tTotal Invalid:%-22s\n\tTotal Infeasible:%-22s\n\tTotal Errors:%-22s\n\tTotal Hanged:%-22s\n\n\n' "$valid" "$invalid" "$infeasible" "$error" "$hang"

fi

valid=0
invalid=0
hang=0
infeasible=0
error=0





# test Float here
if $testFloat ; then

printf "${TEXT_LIGHT_PURPLE}  %s${TEXT_NO_COLOR}\n" "Float"
for filename in Float/*.java; do
	javac $filename
	echo -e "\t$filename"


	classname=${filename%.java}
	classname="${classname}.class"

	methods=$(javap $classname)

	i=0
	end="}"
	while IFS= read -r line; do
		((i++))

		if (( $i > 3 )) && ! [  $end = "$line" ] ; then
			edited=${line%(*}
			IFS=' '
			read -a strarr <<< "$edited"
			method=${strarr[-1]}

			timelimit -t$timelimit java -jar openjml/openjml.jar -esc -method $method -verboseness 2 $filename > out.txt 2>&1

			if grep -q "timelimit:" "out.txt"; then
				printf '    %-30s %s\n' "$method" "hanged"
				((hang++))

			elif ! grep -q "Error:        0" "out.txt"; then
				printf '    %-30s %s\n' "$method" "error"
				((error++))

			elif ! grep -q "Invalid:      0" "out.txt"; then
				printf '    %-30s %s\n' "$method" "invalid"
				((invalid++))

			elif ! grep -q "Infeasible:   0" "out.txt"; then
				printf '    %-30s %s\n' "$method" "infeasible"
				((infeasible++))

			else
				printf '    %-30s %s\n' "$method" "valid"
				((valid++))
			fi

		fi
	done <<< "$methods"

done



((total_valid+=$valid))
((total_invalid+=$invalid))
((total_hang+=$hang))
((total_error+=$error))

printf '\nPrimitives Results:\n\tTotal Valid:%-22s\n\tTotal Invalid:%-22s\n\tTotal Infeasible:%-22s\n\tTotal Errors:%-22s\n\tTotal Hanged:%-22s\n\n\n' "$valid" "$invalid" "$infeasible" "$error" "$hang"

fi

valid=0
invalid=0
hang=0
infeasible=0
error=0





# test Math here
if $testMath ; then

printf "${TEXT_LIGHT_PURPLE}  %s${TEXT_NO_COLOR}\n" "Math"
for filename in Math/*.java; do
	javac $filename
	echo -e "\t$filename"


	classname=${filename%.java}
	classname="${classname}.class"

	methods=$(javap $classname)

	i=0
	end="}"
	while IFS= read -r line; do
		((i++))

		if (( $i > 3 )) && ! [  $end = "$line" ] ; then
			edited=${line%(*}
			IFS=' '
			read -a strarr <<< "$edited"
			method=${strarr[-1]}

			timelimit -t$timelimit java -jar openjml/openjml.jar -esc -method $method -verboseness 2 $filename > out.txt 2>&1

			if grep -q "timelimit:" "out.txt"; then
				printf '    %-30s %s\n' "$method" "hanged"
				((hang++))

			elif ! grep -q "Error:        0" "out.txt"; then
				printf '    %-30s %s\n' "$method" "error"
				((error++))

			elif ! grep -q "Invalid:      0" "out.txt"; then
				printf '    %-30s %s\n' "$method" "invalid"
				((invalid++))

			elif ! grep -q "Infeasible:   0" "out.txt"; then
				printf '    %-30s %s\n' "$method" "infeasible"
				((infeasible++))

			else
				printf '    %-30s %s\n' "$method" "valid"
				((valid++))
			fi

		fi
	done <<< "$methods"
done


((total_valid+=$valid))
((total_invalid+=$invalid))
((total_hang+=$hang))
((total_error+=$error))

printf "\nPrimitives Results:\n  Total Valid:%-22s\n  Total Invalid:%-22s\n  Total Infeasible:%-22s\n  Total Errors:%-22s\n  Total Timeouts:%-22s\n" "$valid" "$invalid" "$infeasible" "$error" "$hang"


fi


printf "\n${TEXT_LIGHT_PURPLE}Overall Results${TEXT_NO_COLOR}:\n  Total Valid:%-22s\n Total Invalid:%-22s\n Total Infeasible:%-22s\n  Total Errors:%-22s\n  Total Timeouts:%-22s\n\n\n" "$total_valid" "$total_invalid" "$total_infeasible" "$total_error" "$total_hang"




