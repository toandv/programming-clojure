;; destructing

(def v [1 2 3 4 5])

(first v)
(last v)
(second v)
(v 2)
(nth v 1)
(.get v 2)

(+ (v 2) (v 1))

;; sequential destructing

(def v [1 5 100.1])
(let [[a b c] v]
  (+ a b c))

;; nested destructing
(def v [1 "clojure" [2 "java"]])
(let  [[_ c [_ j]] v] 
  (println c j))

;; map destructing
(def m {:a 5 :b 6
        :c [7 8 9 ]
        :d {:e 10 :f 11}
        "foo" 88
        42 false})
(let [{a :a a :b} m] 
  (+ a b))

(let [{f "foo"} m] 
  (+ f 12))

(let [{v 42} m] 
  (if v 1 0))
;; TODO
