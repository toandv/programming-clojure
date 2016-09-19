(def greeting "Hello clojure, I just started to love it.")

(class greeting)

(class \a)

(class 1)

(class 1.1)

(class true)

(defn hello 
  [name]
  (clojure.string/join " " 
    ["Hi: " name greeting]))
     
(hello "toan")

(def person {:name "toan" :city "HN"})

person

(class person)

(def person 
  {:name "toan" 
   :city "HN" 
   ::city "HP"})

person

(class :java)

(class #"[a-z*]")

(def foo 
  (read-string "(defn foo [] \"function foo\")"))
foo
(for [i foo]
  (class i))







