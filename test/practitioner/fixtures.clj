(ns practitioner.fixtures
  (:require
    [clojure.test :refer :all]
    [mount.core :as mount]
    [practitioner.config :as config]
    [practitioner.db.datasource :as ds]))


(defn db-connection
  [f]
  (mount/start #'config/config)
  (mount/start #'ds/datasource)
  (f)
  (mount/stop #'config/config)
  (mount/stop #'ds/datasource))
