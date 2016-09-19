(defn reduce
  [f numbers]
  (apply f numbers))

(reduce (fn [a b] (* a b)) [1 2 3 4])
