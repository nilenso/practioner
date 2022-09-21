(ns practitioner.migrations
  (:require
   [mount.core :as mount]
   [migratus.core :as migratus]
   [next.jdbc :as jdbc]
   [practitioner.db.datasource :as ds]
   [practitioner.config :as config]))

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
  [command & id]
  (mount/start #'config/config #'ds/datasource)
  (case command
    "migrate" (migrate)
    "rollback" (rollback)
    "up" (up (Long/parseLong id))
    "down" (down (Long/parseLong id)))
  (mount/stop))
