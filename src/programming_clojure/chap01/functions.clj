(fn [x] 
  (+ 10 x)) 

(defn make-user 
  [username & {:keys [email join-date] 
               :or {join-date (java.util.Date.)}}]
  {:username username
   :join-date join-date
   ;; 2.592e9 -> one month in ms
   :exp-date (java.util.Date. (long (+ 2.592e9 (.getTime join-date))))})

(defn make-user1 
  [username & {email :email 
               join-date :join-date
               :or {join-date (java.util.Date.)}}]
  {:username username
   :join-date join-date
   ;; 2.592e9 -> one month in ms
   :exp-date (java.util.Date. (long (+ 2.592e9 (.getTime join-date))))})

(make-user 'toan :email "dovantoanhp@gmail.com")


;; it's bad don't do that
;; oh man, I want some of those


;; function with multiple arities

(defn inc-by 
  ([x] (inc-by x 1))
  ([x by] (+ x by)))

(inc-by 10)
(inc-by 10 5)

;; simulate pattern matching

(defn match-args
  ([] [])
  ([a] (conj [] a))
  ([a b] (conj [] a b)) 
  ([a b c] (conj [] a b c)))

(defn make-user1 
  [& [user-id]]
  {:user-id (or user-id 
                (str (java.util.UUID/randomUUID)))})

(defn foo
  [& {k ["m" 1]}]
  (inc (or k -1)))
