(ns practitioner.core
  (:gen-class)
  (:require
    [practitioner.http.server :as server]))


(defn -main
  [& args]
  (server/start))

