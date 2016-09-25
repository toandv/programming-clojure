(require 'clojure.xml)
(defn twittwer-followers
  [username]
  (->> (str "https://api.twitter.com/1/users/show.xml?screen_name=" username)
       clojure.xml/parse
       :content
       (filter (comp #{:followers_count} :tag))
       first 
       :content
       first
       Integer/parseInt))
;; memoize 
(defn prime?
  [n]
  (cond
   (== 1 n) false
   (== 2 n) true
   (even? n) false
   :else (->> (range 3 (Math/sqrt n) 2)
              (filter #(zero? (rem n %)))
              empty?)))

;; don't define memoized functions in top-level vars using def
;; define them local to a high-level function call as necessary
(let [m-prime? (memoize  prime?)] 
  (time (m-prime? 111111179))
  (time (m-prime? 111111179)))

c
