(def statuses 
  [{:id 0, :topic-id 1, :content "OK", :created 10}
   {:id 1, :topic-id 1, :content "OK", :created 11}
   {:id 2, :topic-id 1, :content "ERROR", :created 12}
   {:id 3, :topic-id 1, :content "ERROR", :created 13}
   {:id 4, :topic-id 1, :content "ERROR", :created 14}
   {:id 5, :topic-id 1, :content "ERROR", :created 15}
   {:id 6, :topic-id 1, :content "ERROR", :created 16}
   {:id 7, :topic-id 1, :content "ERROR", :created 17}
   {:id 8, :topic-id 1, :content "ERROR", :created 18}
   {:id 9, :topic-id 1, :content "ERROR", :created 19}
   {:id 10, :topic-id 2, :content "ERROR", :created 20}
   {:id 11, :topic-id 2, :content "ERROR", :created 21}
   {:id 12, :topic-id 2, :content "ERROR", :created 22}
   {:id 13, :topic-id 2, :content "ERROR", :created 23}
   {:id 14, :topic-id 2, :content "ERROR", :created 24}
   {:id 15, :topic-id 2, :content "ERROR", :created 25}
   {:id 16, :topic-id 2, :content "ERROR", :created 26}
   {:id 17, :topic-id 2, :content "OK" :created 27}
   {:id 18, :topic-id 2, :content "WARNING" :created 28}
   {:id 19, :topic-id 2, :content "WARNING" :created 29}
   {:id 20, :topic-id 3, :content "WARNING" :created 30}
   {:id 21, :topic-id 3, :content "WARNING" :created 31}
   {:id 22, :topic-id 3, :content "WARNING" :created 32}
   {:id 23, :topic-id 3, :content "WARNING" :created 33}
   {:id 24, :topic-id 3, :content "WARNING" :created 34}
   {:id 25, :topic-id 3, :content "WARNING" :created 35}
   {:id 26, :topic-id 3, :content "WARNING" :created 36}
   {:id 27, :topic-id 3, :content "WARNING" :created 37}
   {:id 28, :topic-id 3, :content "WARNING" :created 38}
   {:id 29, :topic-id 3, :conent "ERROR" :created 39}]

  ;; provided topic-ids, find newest statuses for each topic-id

  (def topic-ids [1 2])

  (->> (filter #((set topic-ids)(:topic-id %)) statuses)
       (group-by :topic-id)
       (vals)
       (map #(sort-by :created > %))
       (map first)))



