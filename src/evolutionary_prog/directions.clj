(ns evolutionary-prog.directions
  (:gen-class)
  (:require [evolutionary-prog.turtleCoords :refer :all]
            [evolutionary-prog.boardUI :refer :all]))

(defn go-up [turtle-atom]
  (let [curr-pos (:current-position @turtle-atom)
        x (get curr-pos 0)
        y (get curr-pos 1)]
    [(dec x) y]))

(defn go-down [turtle-atom]
  (let [curr-pos (:current-position @turtle-atom)
        x (get curr-pos 0)
        y (get curr-pos 1)]
    [(inc x) y]))

(defn go-left [turtle-atom]
  (let [curr-pos (:current-position @turtle-atom)
        x (get curr-pos 0)
        y (get curr-pos 1)]
    [x (dec y)]))

(defn go-right [turtle-atom]
  (let [curr-pos (:current-position @turtle-atom)
        x (get curr-pos 0)
        y (get curr-pos 1)]
    [x (inc y)]))


(defn direction-try [motion turtle-atom]
  "Negative 1 means the turtle is going out of bounds"
  (try 
  (motion turtle-atom)
   (catch Exception e -1)))

(defn not-out-of-bounds? [motion turtle-atom]
  (not (= -1 (direction-try motion turtle-atom))))



(defn seach-for-exit! [board turtle-atom]
  (cond
      ;; needs cond for finding exit (put in later)
    (and
     (not-out-of-bounds? go-right turtle-atom)
     (= 1 (get-board-value board (go-right turtle-atom)))) (do
                                                             (update-turtle-position! (go-right turtle-atom) turtle-atom)
                                                             (update-board! board turtle-atom))
    (and
     (not-out-of-bounds? go-up turtle-atom)
     (= 1 (get-board-value board (go-up turtle-atom)))) (do
                                                          (update-turtle-position! (go-up turtle-atom) turtle-atom)
                                                          (update-board! board turtle-atom))
    (and
     (not-out-of-bounds? go-left turtle-atom)
     (= 1 (get-board-value board (go-left turtle-atom)))) (do
                                                            (update-turtle-position! (go-left turtle-atom) turtle-atom)
                                                            (update-board! board turtle-atom))
    (and
     (not-out-of-bounds? go-down turtle-atom)
     (= 1 (get-board-value board (go-down turtle-atom)))) (do
                                                            (update-turtle-position! (go-down turtle-atom) turtle-atom)
                                                            (update-board! board turtle-atom))
    :else "No more moves to make"))

