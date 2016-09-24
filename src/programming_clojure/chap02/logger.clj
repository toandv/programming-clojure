(defn print-logger 
  [writer] 
  #(binding [*out* writer]
     (println %)))

(def string-writer (java.io.StringWriter.))
(def string-logger (print-logger string-writer))
(string-logger "Hi")
(str string-writer) ;; Hi
