(ns evolutionary-prog.core
  (:gen-class)
  (:require [evolutionary-prog.coords :refer [find-turtle-XY-coord update-turtle-position!]]
            [evolutionary-prog.directions :refer [go-down go-up go-left go-right]]))



;; TO DO
;; update board



(def board [[1 1 1 1 1],
            [1 1 1 1 1],
            [1 1 "X" 1 1],
            [1 1 1 1 1],
            [1 1 1 1 1]])


(def turtle-atom (atom {:current-position [] :previous-position []}))

(update-turtle-position! (find-turtle-XY-coord board) turtle-atom)

;; TIME TO UPDATE BOARD
;; update the atom, then use that to update board

(get-in board (get (:current-position @turtle-atom) 0)) ;; gets X

