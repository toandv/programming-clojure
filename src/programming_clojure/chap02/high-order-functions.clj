(defn adder 
  [n] 
  (fn [x] 
    (+ x n)))

((adder 2) 8) ;; 10

(defn doubler
  [f]
  (fn [& args]
    (* 2 (apply f args))))

