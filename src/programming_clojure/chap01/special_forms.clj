(def f (read-string "(defn f 1)"))

(for [i f]
  (class i))

'd ;; a symbol

(class 'd)
(class (quote a))

(list? '(+ 1 2 4))

''a
'@a

'#(+ % %)


(do println 2)

(do 2)






  
