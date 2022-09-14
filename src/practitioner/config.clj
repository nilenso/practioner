(ns practitioner.config
  (:require
    [aero.core :as aero]
    [clojure.java.io :as io]))


(defn config
  []
  (aero/read-config (io/resource "config.edn")))


(defn db-spec
  []
  (:db-spec (config)))
