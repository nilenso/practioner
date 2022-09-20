(ns practitioner.http.routes
  (:require
    [bidi.ring :refer (make-handler)]
    [next.jdbc :as jdbc]
    [practitioner.db.datasource :as ds]
    [practitioner.views.index :as index-view]
    [ring.util.response :as res]))


(defn index
  [_]
  (res/response (index-view/index)))


(defn health-check
  [_]
  (when (try
          (jdbc/execute! ds/datasource ["select now()"])
          (catch Exception e
            (res/response (.getMessage e))))
    (res/response "pong")))


(def handler
  (make-handler ["/" {""    index
                      "api/" {"ping" health-check}}]))

