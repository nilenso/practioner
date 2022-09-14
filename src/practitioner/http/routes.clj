(ns practitioner.http.routes
  (:require
    [bidi.ring :refer (make-handler)]
    [ring.util.response :as res]))


(defn index-handler
  [request]
  (res/response "Homepage"))


(def handler
  (make-handler ["/" index-handler]))
