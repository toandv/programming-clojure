(doseq [x (range 3)] 
  (println x))

(let [r (range 3)
      rst (rest r)]
  (prn (map str rst))
  (prn (map #(+ 100 %) r))
  (prn (conj r -1) (conj rst -100)))

(let [s (range 1e6)]
  (time (count s)))

(let [s (apply list (range 1e6))]
  (time (count s)))

(cons 0 (range 1 10))

(cons 0 (cons 1 (cons 2 (cons 3 (range 4 10)))))
;; =
(list* 0 1 2 3 (range 4 10))

;; lazy seq
(defn lazy-random-ints 
  "Returns a lazy set of random integers in the range [0, limit)"
  [limit]
  (lazy-seq
   (println "realizing")
   (cons (rand-int limit)
         (lazy-random-ints limit))))

(def rands (take 10 (lazy-random-ints 100)))
(first rands) ;; println "realizing"
(first rands) ;; not  println "realizing"


;; stackoverflow occurs
(defn strict-random-ints 
  "Returns a lazy set of random integers in the range [0, limit)"
  [limit]
  (set
   (cons (rand-int limit)
         (random-ints limit))))
(take 10 (strict-random-ints 100))

;;
(repeatedly 5 (partial rand-int 5))
(repeatedly 4 #(rand-int 5)) 


(def x (next (lazy-random-ints 50)))
;; realizing - realize the first
;; realizing - check if the next seq is  empty and must realize the head of the next seq
;; #'f/x
(def x (rest (lazy-random-ints 50)))
;; realizing - realize the first and the turn the rest
;; #'f/x

(let [[x & rest] (lazy-random-ints 100)])
;; realizing
;; realizing - let use 'next' 
;; nil

;; TODO - head retention


(let [[t d] (split-with #(< % 12) (range 1e8))] 
  (count d) (count t))
;; t still holds the head of the lazy sequence


(defn interpolate 
  "Takes a collection of points (as [x y] tuples), returning a function
   which is a linear interpolation between those points."
  [points]
  (let [results (into (sorted-map) (map vec points))]
    (fn [x]
      (let [[xa ya] (first (rsubseq results <= x))
            [xb ya] (first (subseq results > x))]
        (if (and xa xb)
          (/ (+ (* ya (- xb x)) (* yb (- x xa)))
             (- xb xa))
          (or ya yb))))))




(def results (into (sorted-map) (map vec [`(1 2) `(2 3) [3 4]])))













