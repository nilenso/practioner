(ns practitioner.migrations
  (:require
   [migratus.core :as migratus]
   [next.jdbc :as jdbc]
   [practitioner.db.datasource :as ds]))

(defn migration-config
  []
  {:store         :database
   :migration-dir "db/migrations/"
   :db            {:connection (jdbc/get-connection ds/datasource)}})

(defn migrate
  []
  (migratus/migrate (migration-config)))

(defn rollback
  []
  (migratus/rollback (migration-config)))

(defn up
  [id]
  (migratus/up migration-config id))

(defn down
  [id]
  (migratus/down migration-config id))

(defn migrate-with-command
  [command & args]
  (case command
    "migrate" (migrate)
    "rollback" (rollback)
    "up" (up (map #(Long/parseLong %) args))
    "down" (down (map #(Long/parseLong %) args))))
