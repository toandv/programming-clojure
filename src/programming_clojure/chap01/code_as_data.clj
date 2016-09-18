;; good try
(def f (read-string "(+ 1 5)"))
(count f)
(eval f) ;; this is very nice

(def fact (read-string "(defn fact [numbers] (apply * numbers))"))
(count fact)
((eval fact) [1 2 3 4 5]) ;; this is powerful and beautiful
