(ns practitioner.http.routes-test
  (:require
    [clojure.test :refer [deftest is testing use-fixtures]]
    [practitioner.fixtures :as fixture]
    [practitioner.http.routes :as routes]
    [ring.mock.request :as mock]))


(use-fixtures :once fixture/db-set-up)


(deftest health-check-test
  (testing "Returns pong when healthy"
    (is (= (routes/health-check (mock/request :get "/api/ping"))
           {:status  200
            :headers {}
            :body    "pong"}))))
