
;; clojure.set provides a suite of functions implementing various
;; high-level operations and predicates over sets including
;; subset?, superset?, union, intersection, project
(disj #{1 2 3} 1 2)

(def sm (sorted-map :z 5 :x 9 :y 0 :a 1 :b 2))

(rseq sm)

(subseq sm <= :y)
(subseq > :a < :y)

;; compare is used to define the default sort ascending
(compare 1 2)
(compare "ab" "abc")
(compare ["a" "b" "c"] ["a" "b"])
(compare ["a" 2] ["a" 2 0])

;; All clojure functions implements java.util.Comparator

(def s (repeatedly 10 #(rand-int 100)))
(sort < s)

(sort-by first > (map-indexed vector "Clojure"))
(sort-by clojure.string/lower-case "Clojure")

(defn my-compare [a b] (compare a b))

(sorted-map-by my-compare :y 1 :z 2 :b 3 :a 0)
(sorted-map-by (comp -  my-compare) :y 1 :z 2 :b 3 :a 0

(defn magnitue 
  [x]
  (-> ))

(->> (range) 
     (map #(* % %)) 
     (filter even?) 
     (take 10) 
     (reduce +))
