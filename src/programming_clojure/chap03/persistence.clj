(def version1 {:name "Chas" :info {:age 31 :city :CA}})
(def version2 (update-in version1 [:info :age] + 3))

(def age (:age (:info version1)))

(def age (->> (:info version1)
              (:age)))

(reduce (fn [val key-fn](key-fn val)) version1[:info :age])
(reduce #(%2 %1) version1 [:info :age])

;; linear  recursion 
(defn get-nested [key-vec m]
  (let [[first & rest] key-vec] 
    (if (and first rest) 
      (get-nested rest (first m)) 
      (first m))))
;; 

(defn fac [n]
  (loop [cnt n acc 1]
    (if (zero? cnt) 
      acc
      (recur (dec cnt) (* acc cnt)))))
