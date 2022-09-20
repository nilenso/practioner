(ns practitioner.views.index
  (:require
   [hiccup.page :refer [html5]]))

(defn index
  []
  (html5 [:div {:id "content"} "Index page"]))
