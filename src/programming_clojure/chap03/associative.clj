(def m {:a 1 :b 2 :c 3})

(get m :a)

(get m :x "not found") ;; "not found"

(assoc m :d 4 :e 5)

(dissoc m :a :b)

;; maps and vectors are both associative collections
;; maps associate keys with values
;; vectors associate indices with values

(def v [1 2 3])
(v 1)
(get v 10) ;; get
(get 10 v "found not") ;; "found not"

(v 1 10)


(if-let [e (find {:a 5 :b 6} :a)]
  (format "found %s => %s" (key e) (val e))
  "not found")

(if-let [[k v] (find {:a 5 :b 6} :a)]
  (format "found %s => %s" k v)
  "not found")

 
