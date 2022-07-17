(ns evolutionary-prog.directions
  (:gen-class))

(defn go-up [turtle-atom]
  (let [curr-pos (get (:current-position @turtle-atom) 0)
        x (get curr-pos 0)
        y (get curr-pos 1)]
    [(dec x) y]))

(defn go-down [turtle-atom]
  (let [curr-pos (get (:current-position @turtle-atom) 0)
        x (get curr-pos 0)
        y (get curr-pos 1)]
    [(inc x) y]))

(defn go-left [turtle-atom]
  (let [curr-pos (get (:current-position @turtle-atom) 0)
        x (get curr-pos 0)
        y (get curr-pos 1)]
    [x (dec y)]))

(defn go-right [turtle-atom]
  (let [curr-pos (get (:current-position @turtle-atom) 0)
        x (get curr-pos 0)
        y (get curr-pos 1)]
    [x (inc y)]))