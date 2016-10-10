(def numbers (range 10))

(reduce + numbers)

(macroexpand (reduce + numbers)) 
