(defn character
  [name & {:as opts}]
  (ref (merge {:name name :items #{} :heath 500} opts)))

(def smaug (character "Smaug" :health 500 :strength 400 :items (set (range 50))))
(def bilbo (character "Bilbo" :health 100 :strength 100))
(def gandalf (character "Gandalf" :health 75 :strength 750))

(defn loot
  [from to]
  (dosync
   (when-let [item (first (:items @from))]
     (alter to update-in [:items] conj item)
     (alter from update-in [:items] disj item))))

(defmacro futures
  [n & exprs]
  (vec (for [_ (range n)
             expr exprs] 
         `(future ~expr))))

(defmacro wait-futures
 [& args]
  `(doseq [f# (futures ~@args)]
     @f#))

(wait-futures 1
              (while (do 
                       (Thread/sleep 100)
                       (loot smaug bilbo)))
              (while (do 
                       (Thread/sleep 100)
                       (loot smaug gandalf))))
;; test
(def total (reduce + (map count (map :items [@bilbo @gandalf]))))
;; better total
(def total (recude + (map (comp count :items deref) [bilbo gandalf])))

(empty? (clojure.set/intersection (:items @bilbo) (:items @gandalf)))

(= (set (range 50)) (clojure.set/union (:items @bilbo) (:items @gandalf)))

(filter (:items @bilbo) (:items @gandalf))
