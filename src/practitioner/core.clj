(ns practitioner.core
  (:gen-class)
  (:require
    [practitioner.db.migration :as migration]
    [practitioner.http.server :as server]))


(defn -main
  [& args]
  (migration/migrate-up)
  (server/start))

