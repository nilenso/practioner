(ns practitioner.http.routes-test
  (:require
    [clojure.test :refer :all]
    [mount.core :as mount]
    [practitioner.config :as config]
    [practitioner.fixtures :as fixture]
    [practitioner.http.routes :refer :all]))


(use-fixtures :once fixture/start-db-connection fixture/stop-db-connection)


(deftest health-check-test
  (testing "Returns pong when healthy"
    (with-redefs [http/get (fn [url] {:body "test"})]
      (let [response (health-check (http/get "localhost:3000/ping"))]
        (is (= "pong" (:body response)))))))


(run-tests)
