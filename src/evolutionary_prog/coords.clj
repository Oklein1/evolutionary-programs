(ns evolutionary-prog.coords
  (:gen-class))


(defn find-turtle-Y-coord [board] ; works
         (loop [counter 0
                board-pos board]
           (cond 
             (empty? board-pos) 0
             (= "X" (first board-pos)) counter 
             :else (recur (inc counter) (rest board-pos)))))

(defn turtle-exist? [board]
  (not (empty? (filter #(= "X" %) board))))


(defn find-turtle-XY-coord [board]
  (loop [counter 0
         board-pos board]
    (cond
      (empty? (first board-pos)) nil
      (turtle-exist? (first board-pos)) [counter (find-turtle-Y-coord (first board-pos))]
      :else (recur (inc counter) (rest board-pos)))))




(defn update-turtle-position! [current-instance turtle-atom]
  "Updates the curr position in map and conjs previous curr pos to end of vector"
  (let [previous-instance (get (:current-position @turtle-atom) 0)]
    (if (empty? previous-instance)
      (swap! turtle-atom update :current-position conj current-instance)
      (do
        (swap! turtle-atom update
               :current-position (fn [_] current-instance))
        (swap! turtle-atom update :previous-position conj previous-instance)))))
