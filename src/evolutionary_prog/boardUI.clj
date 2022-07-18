(ns evolutionary-prog.boardUI
  (:gen-class))

(defn update-board! [board turtle-atom]
  (let [curr (:current-position @turtle-atom)
        prev (last (:previous-position @turtle-atom))]
    (do 
      (swap! board update-in prev (fn [_] 0))
      (swap! board update-in  curr (fn [_] "X")))))


(defn get-board-value [board coord]
  "X means Turtle is in position.
   1 Means space is Empty
   0 Means previous position"
  (get-in @board coord))