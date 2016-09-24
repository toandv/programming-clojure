
;; sum and negate and str
(defn negated-sum-str 
  [& numbers] 
  (str (- (apply + numbers))))

;; can be written like this
;; comp to compose functions
(def composed-negated-sum-str 
  (comp str - +))

;; CamelCase -> hyphen-delimited
(require '[clojure.string :as str])
(def camel->keyword (comp keyword
                          str/join
                          (partial interpose \-)
                          (partial map str/lower-case)
                          #(str/split % #"(?<=[a-z])(?=[A-Z])")))
;; threading macro
(defn camel->keyword
  [s]
  (->> (str/split s #"(?<=[a-z])(?=[A-Z])")
       (map str/lower-case)
       (interpose \-)
       str/join
       keyword))
