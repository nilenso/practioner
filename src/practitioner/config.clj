(ns practitioner.config
  (:require
    [aero.core :as aero]
    [clojure.java.io :as io]
    [mount.core :refer [defstate]]))


(defstate config
  :start (aero/read-config (io/resource "config.edn"))
  :stop nil)


(defn db-spec
  []
  (:db-spec config))


(defn http-port
  []
  (get-in config [:http-server :port]))
