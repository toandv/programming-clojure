;; good try
(def f (read-string "(+ 1 5)"))
(count f)
(eval f) ;; this is very nice

(def product_f (read-string "(defn product [numbers] (apply * numbers))"))
(count product_f)
(def product (eval product_f))

((eval product_f)
  [1 2 3 4 5]) ;; this is powerful and beautiful
(product [1 2])

(defn reduce
  [f numbers]
  (apply f numbers))

(reduce (fn [a b] (* a b)) [1 2 3 4])



