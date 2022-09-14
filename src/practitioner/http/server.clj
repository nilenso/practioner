(ns practitioner.http.server
  (:gen-class)
  (:require
    [practitioner.http.routes :refer (handler)]
    [ring.adapter.jetty :as jetty])
  (:import
    (org.eclipse.jetty.server
      Server)))


(defonce ^Server server (atom nil))


(defn start
  []
  (reset! server
          (jetty/run-jetty server
                           {:port 3000
                            :join? false})))


(defn stop
  []
  (.stop ^Server @server)
  (reset! server nil))

