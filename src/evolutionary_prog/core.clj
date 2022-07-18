(ns evolutionary-prog.core
  (:gen-class)
  (:require [evolutionary-prog.turtleCoords :refer :all]
            [evolutionary-prog.directions :refer :all]
            [evolutionary-prog.boardUI :refer :all]))



(def board (atom [[1 1 1 1 1],
                  [1 1 1 1 1],
                  [1 1 "X" 1 1],
                  [1 1 1 1 1],
                  [1 1 1 1 1]]))

(def turtle-atom (atom {:current-position [] :previous-position []}))
(update-turtle-position! (find-turtle-XY-coord @board) turtle-atom) ;; gets first position

(seach-for-exit! board turtle-atom)


(defn main []
  (repeatedly 13 (fn []
                 (seach-for-exit! board turtle-atom))))
