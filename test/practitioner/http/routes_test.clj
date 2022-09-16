(ns practitioner.http.routes-test
  (:require
    [clojure.test :refer :all]
    [practitioner.fixtures :as fixture]
    [practitioner.http.routes :refer :all]))


(use-fixtures :once fixture/start-db-connection fixture/stop-db-connection)


(deftest health-check-test
  (testing "Returns pong when healthy"
    (with-redefs [http/get (fn [url] {:body "test"})]
      (let [response (health-check (http/get "localhost:3000/api/ping"))]
        (is (= "pong" (:body response)))))))


