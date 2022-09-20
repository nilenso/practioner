(ns practitioner.core
  (:gen-class)
  (:require
   [mount.core :as mount]
   [practitioner.http.server :as server]
   [practitioner.migrations :as migrations]))

(defn add-shutdown-hook
  []
  (.addShutdownHook (Runtime/getRuntime)
                    (Thread. ^Runnable #(mount/stop))))

(defn -main
  []
  (mount/start)
  (migrations/migrate)
  (add-shutdown-hook))


