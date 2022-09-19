(ns practitioner.http.routes-test
  (:require
    [clojure.test :refer :all]
    [practitioner.fixtures :as fixture]
    [practitioner.http.routes :refer :all]
    [ring.mock.request :as mock]))


(use-fixtures :once fixture/db-set-up)


(deftest health-check-test
  (testing "Returns pong when healthy"
    (is (= (health-check (mock/request :get "/api/ping"))
           {:status  200
            :headers {}
            :body    "pong"}))))
