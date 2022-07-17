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