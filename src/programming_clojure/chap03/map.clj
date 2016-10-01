(def m {:a 1 :b 2 :c 3 :d 4})

(let [{a :a b :b d :d} m]
  (+ a b d))

(let [{:keys [a b d c]} m] 
  (+ a b c d))

(vals m)
(keys m)

(def playlist
  [{:title "Elephant" :artist "The White Triples" :year 2003}
   {:title "Helioself" :artist "Papas Fritas" :year 1997}
   {:title "Stories from the City, Stories from the Sea" 
    :artist "PJ Harvey" :year 2000}
   {:title "Buildings and Grounds" :artist "Papas Fritas" :year 2000}
   {:title "Zen Rodeo" :artist "Mardi Gras BB" :year 2002}])

(map :title playlist) ;; returns a seq of titles;
(filter :year playlist) ;; returns a seq of films having :year

(defn sumarize [{:keys [title artist year]}]
  (str title " / " artist " / " year))

(map sumarize playlist)

(group-by #(rem % 3) (range 10))

(group-by (juxt :artist :year) playlist)

;; pattern for processing a map
(into {} (for [[k v] (group-by key-fn coll)]
           [k (summarize v)]))











