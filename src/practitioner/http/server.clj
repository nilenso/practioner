(ns practitioner.http.server
  (:gen-class)
  (:require
    [mount.core :refer [defstate]]
    [practitioner.config :as config]
    [practitioner.http.routes :as routes]
    [ring.adapter.jetty :as jetty]
    [ring.middleware.flash :refer [wrap-flash]]
    [ring.middleware.session :refer [wrap-session]]))


(def app
  (-> routes/handler
      wrap-session
      wrap-flash))


(defn start
  []
  (jetty/run-jetty app
                   {:port  (config/http-port)
                    :join? false}))


(defn stop
  [server]
  (println "Stopping Server")
  (.stop server))


(defstate server
  :start (start)
  :stop (stop server))
