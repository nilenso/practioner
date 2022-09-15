(ns practitioner.db.datasource
  (:require
    [mount.core :refer [defstate]]
    [next.jdbc :as jdbc]
    [practitioner.config :as config]))


(defstate db-spec
  :start (config/db-spec)
  :stop nil)


(defstate datasource
  :start (jdbc/get-datasource db-spec)
  :stop nil)


