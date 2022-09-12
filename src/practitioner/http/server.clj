(ns practitioner.http.server
  (:require
    [ring.adapter.jetty :as jetty]))


(defonce server (atom nil))


(defn start
  []
  (reset! server
          (jetty/run-jetty (fn [req] {:status 200 :body "Hello World" :headers {}})  ; a really basic handler
                           {:port 3000
                            :join? false})))


(defn stop
  []
  (.stop @server)
  (reset! server nil))

