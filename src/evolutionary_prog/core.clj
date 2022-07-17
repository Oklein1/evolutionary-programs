(ns evolutionary-prog.core
  (:gen-class)
  (:require [evolutionary-prog.coords :refer [find-turtle-XY-coord]]))


;; TO DO
;; Now give directions
;; Update coord with directions
;; update board


(def board [[1 1 1 1 1],
            [1 1 1 1 1],
            [1 1 1 1 1],
            [1 1 1 1 1],
            [1 1 1 "X" 1]])

;; (find-turtle-XY-coord board)

(def turtle-coord (atom {:current-position [2 2] :previous-position []}))



;; TEST
;; TEST COMPLETED: Everything works.
(def instance1 (assoc turtle-coord :current-position (find-turtle-XY-coord board)))
(def instance2 (assoc @turtle-coord :current-position (find-turtle-XY-coord board)))

turtle-coord

instance1
instance2

;; (defn update-turtle-position [current-instance]
;;   (let [previous-instance (:current-position turtle-coord)]
;;     (assoc turtle-coord :current-position current-instance 
;;            :previous-positions (conj (:previous-position turtle-coord) previous-instance))))


;; END OF TEST


(defn update-turtle-position [current-instance]
  "Updates the curr position in map and conjs previous curr pos to end of vector"
  (let [previous-instance (:current-position @turtle-coord)]
    (do 
      (swap! turtle-coord update
              :current-position (fn [_] (get current-instance :current-position)))
      (swap! turtle-coord update :previous-position conj previous-instance)
      )))






(update-turtle-position instance2)