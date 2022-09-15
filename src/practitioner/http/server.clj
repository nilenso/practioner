(ns practitioner.http.server
  (:gen-class)
  (:require
    [mount.core :as mount]
    [practitioner.http.routes :refer (handler)]
    [ring.adapter.jetty :as jetty]))


(defonce server (atom nil))


(defn start
  []

  (reset! server
          (jetty/run-jetty handler
                           {:port 3000
                            :join? false})))
(defn stop
  []
  (.stop @server)
  (reset! server nil))


;(defstate server
;  :start (start-server)
;  :stop (stop-server server))
