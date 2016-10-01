(vector 1 2 3 4)
(vec (range 1 10 2))

(defn euclidian-division
  [x y] 
  [(quot x y) (rem x y)])

(def euclidian-division1 (juxt quot rem))

(euclidian-division 42 8)
(euclidian-division1 42 8)

(let [[q r] (euclidian-division 53 7)]
  (str "53/7 = " q " * 7 + " r))
