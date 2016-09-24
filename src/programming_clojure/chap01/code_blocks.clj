
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

;; function with multiple arities
(def strange-adder (fn adder-self-reference 
                     ([x] (adder-self-reference x 1))
                     ([x y] (+ x y))))
(strange-adder 10)
(strange-adder 10 20)

;; variadic function
(defn concat-rest 
  [x & rest]
  (apply str (butlast rest)))
(concat-rest 0 1 2 3 4)

;; destructing rest args
(defn make-user 
  [& [user-id]] 
  {:user-id (or user-id 
                (str (java.util.UUID/randomUUID)))})
(make-user)
(make-user 1)
