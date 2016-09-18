(defn average 
  [numbers]
  (/ (apply + numbers)
     (count numbers)))

(average [1 2 3 4 5])


