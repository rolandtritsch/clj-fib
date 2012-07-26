(comment
  Copyright (C) 2010 Roland Tritsch

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  )

(comment
  Solving the fibonacce problem with a very simple recursive algorithm. With
  large numbers fib will fail with a stack overflow. fib-better is using tail
  recursion and can cal any number.
  )

(ns ^{:doc "A solution to the Fibonacci Problem"
      :author "roland@tritsch.org"
      }
  org.tritsch.fibonacci
  (:gen-class))

(defn fib
  "calculates the fibunacci sequence to the Nth level"
  ([n]
     (cond
      (<= n 0) nil
      (= n 1) 0
      (= n 2) 1
      (>= n 2) (fib 0 1 (- n 2))))
  ([alpha beta n] 
     (if (= n 0) 
       beta
       (fib beta (+ alpha beta) (dec n)))))

(defn fib-better
  "calculates the fibunacci sequence to the Nth level (using loop/recur)"
  ([n]
     (cond
      (<= n 0) nil
      (= n 1) 0
      (= n 2) 1
      (>= n 2) (loop [alpha 0 beta 1 level (- n 2)] 
		 (if (zero? level) 
		   beta
		   (recur beta (+ alpha beta) (dec level)))))))

; --- Java Stuff

(defn pfib
  "print the fibunacci seq to the Nth level"
  ([n] (do
	 (println n ":" (fib n))
	 (if (> n 1) (pfib (dec n))))))

(defn usage "Describe usage()"
  ([] (println "Usage: fibonacci Nth")))

(defn -main "Java Main Function"
  ([& args]
     (do
       (usage)
       (pfib (read-string (nth args 0))))))