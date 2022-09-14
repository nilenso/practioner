(ns practitioner.db.migration
  (:require
    [migratus.core :as migratus]
    [next.jdbc :as jdbc]
    [practitioner.config :as config]))


(def config
  {:store         :database
   :migration-dir "db/migrations/"
   :db            {:datasource (jdbc/get-datasource (config/db-spec))}})

(defn migrate-up
  ([]
   (migratus/migrate config))
  ([id]
   (migratus/up config id)))


(defn migrate-down
  ([]
   (migratus/rollback config))
  ([id]
   (migratus/down config id)))

