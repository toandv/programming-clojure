(defn character
  [name & {:as opts}]
  (ref (merge {:name name :items #{} :health 500} opts)))

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

#_(wait-futures 1
              (while (do
                       (Thread/sleep 100)
                       (loot smaug bilbo)))
              (while (do
                       (Thread/sleep 100)
                       (loot smaug gandalf))))
;; test
;; (def total (reduce + (map count (map :items [@bilbo @gandalf]))))
;; better total
;; (def total (recude + (map (comp count :items deref) [bilbo gandalf])))

;; (empty? (clojure.set/intersection (:items @bilbo) (:items @gandalf)))

;; (= (set (range 50)) (clojure.set/union (:items @bilbo) (:items @gandalf)))

;; (filter (:items @bilbo) (:items @gandalf))

(defn flawed-loot
  [from to]
  (dosync
   (when-let [item (first (:items @from))]
     (commute to update-in [:items] conj item)
     (commute from update-in [:items] disj item))))

(defn fixed-loot
  [from to]
  (dosync
   (when-let [item (first (:items @from))]
     (commute to update-in [:items] conj item)
     (alter from update-in [:items] disj item))))

#_(wait-futures 1
              (while (do
                       (Thread/sleep 100)
                       (flawed-loot smaug bilbo)))
              (while (do
                       (Thread/sleep 100)
                       (flawed-loot smaug gandalf))))

(defn attack
  [aggressor target]
  (dosync
   (let [damage (* (rand 0.1) (:strength @aggressor))]
     (commute target update-in [:health] #(max 0 (- % damage))))))

(defn heal
  [healer target]
  (dosync
   (let [aid (* (rand 0.1) (:mana @healer))]
     (when (pos? aid)
       (commute update-in healer [:mana] - (max 5 (/ aid 5)))
       (commute update-in target [:health] + aid)))))

(defn alive?
  [character]
  (pos? (:health @character)))

(def alive??? (comp pos? :health))

(defn play
  [character action other]
  (while (and (alive? character)
              (alive? other)
              (action character other))
    (Thread/sleep (rand-int 50))))

(wait-futures 1 
              (play bilbo attack smaug)
              (play smaug attack bilbo))




















