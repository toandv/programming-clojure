;; let x 5
(loop [x 5]
  (if (neg? x)
    x
    (recur (dec x))))

;; loop head is established by  a function
(defn countdown 
  [x]
  (if (zero? x)
    :blastoff!
    (do (println x)
        (recur (dec x)))))

;; a native reimplementation of Clojure's RELP

(defn embedded-repl
  "A native Clojure REPL implementation: Enter `:quit` to exit."
  []
  (print (str (ns-name *ns*) ">>> "))
  (flush)
  (let [expr (read)
        value (eval expr)]
    (when (not= :quit value)
      (println value)
      (recur))))
