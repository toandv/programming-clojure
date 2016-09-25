
;; swap pairs

(defn swap-pairs
  [sequential]
  (into (empty sequential)
        (interleave
         (take-nth 2 (drop 1 sequential))
         (take-nth 2 sequential))))

(defn map-map 
  [f m] 
  (into (empty m) 
        (for [[k v] m]
          [k (f v)])))

;; unsorted in, unsorted out
(map-map inc (hash-map :z 5 :c 6 :a 0))
;; sorted in, sort out
(map-map inc (sorted-map :z 5 :c 6 :a 0))
