(ns practitioner.fixtures
  (:require
    [clojure.test :refer :all]
    [mount.core :as mount]
    [practitioner.config :as config]
    [practitioner.db.datasource :as ds]))


(defn start-db-connection
  [f]
  (mount/start #'config/config)
  (mount/start #'ds/datasource)
  (f))


(defn stop-db-connection
  [f]
  (mount/stop #'config/config)
  (mount/start #'ds/datasource)
  (f))
