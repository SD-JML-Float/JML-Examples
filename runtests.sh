#!/bin/bash


#Test Script
# requires timelimit
#	can be installed on ubuntu via suda apt install timelimit

timelimit=30
testPrimitives=true
testDouble=true
testFloat=true
testMath=true

valid=0
invalid=0
hang=0





#test primitives here
if $testPrimitives ; then

echo "Primitives"
for filename in PrimitiveOps/*.java; do
	javac $filename
	echo -e "\t$filename"
	for classname in PrimitiveOps/*.class; do
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
					printf '\t\t%-30s %s\n' "$method" "hanged"
					((hang++))
				fi

				if grep -q "Invalid:      0" "out.txt"; then
					printf '\t\t%-30s %s\n' "$method" "valid"
					((valid++))						
				fi
				
				if  grep -q "Invalid:      1" "out.txt"; then
					printf '\t\t%-30s %s\n' "$method" "invalid"
					((invalid++))						
				fi
				
			fi
		done <<< "$methods"

	done
done
fi


total_valid=$valid
total_invalid=$invalid
total_hang=$hang

printf '\nPrimitives Results:\n\tTotal Valid:%-15s\n\tTotal Invalid:%-15s\n\tTotal Hanged:%-15s\n\n\n' "$valid" "$invalid" "$hang"

valid=0
invalid=0
hang=0



#test Double here
if $testDouble ; then

echo "Double"
for filename in Double/*.java; do
	javac $filename
	echo -e "\t$filename"
	for classname in Double/*.class; do
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
					printf '\t\t%-30s %s\n' "$method" "hanged"
					((hang++))
				fi

				if grep -q "Invalid:      0" "out.txt"; then
					printf '\t\t%-30s %s\n' "$method" "valid"
					((valid++))						
				fi
				
				if  grep -q "Invalid:      1" "out.txt"; then
					printf '\t\t%-30s %s\n' "$method" "invalid"
					((invalid++))						
				fi
				
			fi
		done <<< "$methods"

	done
done
fi



((total_valid+=$valid))
((total_invalid+=$invalid))
((total_hang+=$hang))

printf '\nDoubles Results:\n\tTotal Valid:%-15s\n\tTotal Invalid:%-15s\n\tTotal Hanged:%-15s\n\n\n' "$valid" "$invalid" "$hang"

valid=0
invalid=0
hang=0






#test Float here
if $test_Float ; then

echo "Float"
for filename in Float/*.java; do
	javac $filename
	echo -e "\t$filename"
	for classname in Float/*.class; do
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
					printf '\t\t%-30s %s\n' "$method" "hanged"
					((hang++))
				fi

				if grep -q "Invalid:      0" "out.txt"; then
					printf '\t\t%-30s %s\n' "$method" "valid"
					((valid++))						
				fi
				
				if  grep -q "Invalid:      1" "out.txt"; then
					printf '\t\t%-30s %s\n' "$method" "invalid"
					((invalid++))						
				fi
				
			fi
		done <<< "$methods"

	done
done
fi


((total_valid+=$valid))
((total_invalid+=$invalid))
((total_hang+=$hang))

printf '\nFloats Results:\n\tTotal Valid:%-15s\n\tTotal Invalid:%-15s\n\tTotal Hanged:%-15s\n\n\n' "$valid" "$invalid" "$hang"

valid=0
invalid=0
hang=0





#test Math here
if $testMath ; then

echo "Math"
for filename in Math/*.java; do
	javac $filename
	echo -e "\t$filename"
	for classname in Math/*.class; do
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
					printf '\t\t%-30s %s\n' "$method" "hanged"
					((hang++))
				fi

				if grep -q "Invalid:      0" "out.txt"; then
					printf '\t\t%-30s %s\n' "$method" "valid"
					((valid++))						
				fi
				
				if  grep -q "Invalid:      1" "out.txt"; then
					printf '\t\t%-30s %s\n' "$method" "invalid"
					((invalid++))						
				fi
				
			fi
		done <<< "$methods"

	done
done
fi

((total_valid+=$valid))
((total_invalid+=$invalid))
((total_hang+=$hang))

printf '\nMath Results:\n\tTotal Valid:%-15s\n\tTotal Invalid:%-15s\n\tTotal Hanged:%-15s\n\n\n' "$valid" "$invalid" "$hang"



printf '\n\n\n\n Overall Results:\n\tTotal Valid:%-15s\n\tTotal Invalid:%-15s\n\tTotal Hanged:%-15s\n\n\n' "$total_valid" "$total_invalid" "$total_hang"




