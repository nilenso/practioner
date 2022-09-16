(ns practitioner.db.datasource
  (:require
    [mount.core :refer [defstate]]
    [next.jdbc :as jdbc]
    [practitioner.config :as config]))


(defstate datasource
  :start (jdbc/get-datasource (config/db-spec))
  :stop nil)


