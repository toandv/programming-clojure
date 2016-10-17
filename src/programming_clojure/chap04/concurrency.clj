(def d (delay (println 
               (Thread/currentThread) "Running...") 
              :done!))
(deref d)

(def a-fn (fn []
            (println "Running...")
            :done!))
a-fn

;; sa

(defn get-site
  [url]
  (delay (slurp url)))

(get-site "https://clojuredocs.org")

(def long-calculation (future (apply + (range 10e5))))

(def p (promise))

(def a (promise))
(def b (promise))
(def c (promise))

(def sum (future 
           (deliver c (+ @a @b)) 
           (println "Delivery complete!")))

;; this is an async fn
(defn async-fn
  [callback-fn & args]
  (future (apply callback-fn args)))

;; create a wrapper to make the async to a sync fn

(defn sync-fn
  [asyn-fn & args]
  (let [result (apply async-fn args)]
       @result))














