(do 
  (println "hi")
  (apply * [1 2 3 4]))

(rand-int 10)

(let [a (rand-int 10)
      b (rand-int 10)]
  ;; without do block this still works since a do block is added 
  ;; by default to wrap the body of blocks or special forms 
  (do 
    (println (format "You rolled a %s and a %s" a b)) 
    (+ a b)))

(defn hypo 
  [x y] 
  (let [x2 (* x x)
        y2 (* y y)]
    (Math/sqrt (+ x2 y2))))

;; a local that is defined by a let cannot be overriden, or the local is immutable 
(let [x 10]
  (def x 1)
  (println x)) ;; prints 10
 
(let [x 10]
  (let [x 1] 
    (println x)) ;; prints 1
  (println x))   ;; prints 10             

