(Def m {:a 1 :b 2 :c 3 :d 4})

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

(defn reduce-by
  [key-fn f init coll]
  (reduce (fn [summaries x]
            (let [k (key-fn x)]
              (assoc summaries k (f (summaries k init) x)))) 
          {} coll))


(def orders
  [{:product"Clock", :customer "Wile Coyote", :qty 6, :total 300}
   {:product "Dynamite", :customer "Wile Coyote", :qty 20, :total 5000}
   {:product  "Shotgun", :customer "Elmer Fudd", :qty 2, :total 800}
   {:product  "Shells", :customer "Elmer Fudd", :qty 4, :total 100}
   {:product  "Hole", :customer "Wile Coyote", :qty 1, :total 1000}
   {:product  "Anvil", :customer "Elmer Fudd", :qty 2, :total 300}
   {:product  "Anvil", :customer "Wile Coyote", :qty 6, :total 900}])

(reduce-by :customer #(+ %1 (:total %2)) 0 orders)

(reduce (fn [acc order]
          (let [product (:product order)]
            (assoc acc 
                   product 
                   (+ (acc product 0) (:qty order))))) 
        {}  
        orders)

(reduce-by :product 
           #(conj % (:customer %2)) 
           #{} 
           orders)
(reduce-by (juxt :customer :product) 
           #(+ %1 (:total %2)) 0 orders)
