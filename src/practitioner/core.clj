(ns practitioner.core
  (:gen-class)
  (:require
    [mount.core :as mount]
    [practitioner.migrations :as migrations]
    [practitioner.http.server :as server]))


(defn -main
  []
  (mount/start)
  (migrations/migrate)
  (server/start))
