FIBONACCI PROBLEM SOLVER
=================

This program calculates the Nth element of the 
Fibonacci sequence.

Just run ...

> mvn clojure:repl

... from the command line and change the namespace to ...

user=> (ns org.tritsch.fibonacci)

You can now run the algorithm by invoking fib with an
arbitrary numbers. If the numbers are very big the implementation
will fail with a stackoverflow. fib-better is using tail recursion and
is able to calc any number.

org.tritsch.fibonacci=> (fib 10)
org.tritsch.fibonacci=> (fib 100000)
org.tritsch.fibonacci=> (fib-better 100000)

You can also run ...

> mvn clean clojure:compile package

... to build a jar and use ...

> java -jar target/fibonacci-1.0.0-SNAPSHOT.jar 10

... to run the alogorithm and to print the first N elements
of the sequence.
