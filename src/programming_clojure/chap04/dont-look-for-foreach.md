## Don't look for for loop when using a functional programming language

We a list/seq/array of something, we often want to find a way to
iterate over it and may do something with each element.

### The normal process:

1. loop over the list
2. you're given each element in the list
3. you do something with each element, e.g: print to stdout 

This is very common in imperative languages like: Java or C#:

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
for (Integer number: numbers) {
    System.out.println(number);
    // or something else
}
```
But in fact, we don't just print out the list, but we need to do something with it,
for example, double all elements in list.
So we should focus on the goal, doubling all elements in the list, 
and don't have to think about how we iterate the list or get each element.

By thinking and doing that way, we're getting to a higher level of seeing and solving a problem, 
focusing what really affects the final result and ignoring things that are not important.

### Doubling all elements in functional way

In clojure, or even in Java, we only define how to double a number, 
which is the main thing we must and should take care of, and let the language do the rest for us.

```clojure
;; #(* % 2) - an  anonymous function doubling a number
(def numbers [1 2 3 4 5])
(map #(* % 2) numbers) ;; we get a new list of doubled elements
```



