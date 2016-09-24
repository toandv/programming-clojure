
;; convert a collections into a map of [v (* v v)]
(reduce 
 (fn [m v] 
   (assoc m v (* v v))) 
 {} ;; the seed map
 [1 2 3 4 5])

(reduce 
 #(assoc % %2 (* %2 %2))
 {}
 [1 2 3 4 5])

;; 100 IS THE SEED NUMBER
(reduce + 100 [1 2 3 4])

;; function partial
(def only-strings (partial filer strings?))
(string-only [1 2 "1" "2"]) ;; ("1" "

;; swap word M-<left> M-<right>
;; unwrap expression M-s
