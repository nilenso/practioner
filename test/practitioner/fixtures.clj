(ns practitioner.fixtures
  (:require
    [mount.core :as mount]
    [practitioner.config :as config]
    [practitioner.db.datasource :as ds]))


(defn db-set-up
  [f]
  (mount/start #'config/config)
  (mount/start #'ds/datasource)
  (f)
  (mount/stop))

