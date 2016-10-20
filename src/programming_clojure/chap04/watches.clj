(def sarah (atom {:name "Sarah" :age 25 :wears-glasses? false}))

(def history (atom ())) ;; why do we need an atom?

(defn log->list
  [dest-atom key source old new]
  (when (not= old new) 
    (swap! dest-atom conj old))) ;; we can store these states in db if we want

(add-watch sarah :record (partial log->list history))

(swap! sarah assoc :married true)
(swap! sarah update-in [:age] inc)
(swap! sarah assoc :wears-glasses? true)














