(defn phone-numbers
  [text]
  (re-seq #"(\d{3})[\.-]?(\d{3})[\.-]?(\d{4})" text))

(defn create-files 
  [n size]
  (repeat n
          (apply str
                 (concat (repeat size \space)
                         "Sunil: 617.555.2937, Betty: 508.555.2218"))))

(def files-100-100000 (create-files 100 100000))
(def files-100000-100 (create-files 100000 100))

(time (dorun (map phone-numbers files-100-100000)))
(time (dorun (pmap phone-numbers files-100-100000)))

;; If the operation being parallelized does not have a significant enough runtime, 
;; that overhead will dominate the real work being performed; 
;; this can make a naive application of pmap slower than the equivalent use of map

(time (dorun (map phone-numbers files-100000-100)))
(time (dorun (pmap phone-numbers files-100000-100)))


;; The lesson is clear: use pmap when the operation
;; you’re performing is parallelizable in the first place, and is significant enough for each
;; value in the seq that its workload will eclipse the process coordination inherent in its parallelization

(time (->> (partition-all 250 files-100000-100)
           (pmap (fn [chunk] (doall (map phone-numbers chunk))))
           (apply concat)
           (dorun)))

(defn long-running-job [n]
  (Thread/sleep 3000)
  (+ n 10))

(time (doall (map long-running-job (range 4))))
(time (doall (pmap long-running-job (range 4))))
