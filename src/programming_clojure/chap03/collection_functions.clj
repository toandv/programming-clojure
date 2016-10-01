(defn get-bar
  [map] 
  (map :bar))

(get-bar nil) ;; NPE

(defn get-foo
  [map]
  (:foo map))

(get-foo nil) ;; nil

(map :name [{:age 21 :name "David"}
            {:gender :f :name "Suzanne"}
            {:name "Sara" :location "NYC"}])

(some #{1 3 7} (range 0 10 2))
(some #{1 3 7} (range 1 10 2))

(filter :name [{:age 21 :name "David"}
            {:gender :f :name "Suzanne"}
            {:nick-name "Sara" :location "NYC"}])
