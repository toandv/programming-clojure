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

(def user-info 
  ["toandv" 2016 
   :name "Toan" 
   :city "Ha Noi"])
(let [[username account-year & extra-info] 
      {:keys [name city]} ])

(defn create-random-v 
  [seed]             ;; the seed
  [(rand-int seed)   ;; first random number
   (rand-int seed)]) ;;  the second number

;; let retaining the destructing value
(let [[x y :as point] (create-random-v 10)]
  (println x y point (create-random-v 10)))

;; slurp and barf M-( C-<left> C-<right>
(defn my-command ()
  (do-something)
  (do-something)
  (conclude-doing-something))

;; map destructing

(let [{r1 :x r2 :y :as randoms}
      (zipmap [:x :y :z] (repeatedly (partial rand-int 10 )))]
  (assoc randoms :sum (+ r1 r2)))

;; default value for k
(def m {:x 10 :y 5})
(let [{k :k x :x
       :or {k 10}} m] 
  (+ k x))

;; http://emacsrocks.com/

(def chas {:name "Chas" :age 31 :location "Chicago"})
(let [{name :name age :age location :location} chas] 
  (format "%s is %s years old and lives in %s" 
          name age location))
(let [{:key [name age location]} chas] 
  (format "%s is %s years old and lives in %s" 
          name age location))
