(def sarah (atom {:name "Sarah" :age 25 :wears-glasses? false}))
(swap! sarah update-in [:age] + 3)

(swap! sarah (comp #(update-in % [:age] inc)
                   #(assoc % :wears-glasses? true)))


(defmacro futures
  [n & exprs]
  (vec (for [_ (range n)
             expr exprs] 
         `(future ~expr))))

(defmacro wait-futures
 [& args]
  `(doseq [f# (futures ~@args)]
     @f#))

(def xs (atom #{1 2 3}))
(wait-futures 1 
              (swap! xs #(do (Thread/sleep 250) 
                             (println "Trying 4") 
                             (conj % 4)))
              (swap! xs #(do (Thread/sleep 500)
                             (println "Tryinig 5")
                             (conj % 5))))

(def x (atom 2000))
(defn echo-watch
  [key identity oldv newv]
  (println oldv "=>" newv))
(add-watch x :echo echo-watch)

(compare-and-set! x 1000 3000)
(compare-and-set! x 2000 3000)
(compare-and-set! x @x 3000)






















