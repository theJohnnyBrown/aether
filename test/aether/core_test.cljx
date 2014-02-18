(ns aether.core-test
  #+cljs (:require-macros [cemerick.cljs.test
                           :refer [is are deftest testing run-tests]])
  (:require [aether.core :as ae]
            #+cljs [cemerick.cljs.test :as t]
            #+clj [clojure.test :refer [is are deftest testing run-tests]]))


(deftest a-test
  (testing #+cljs "Failing in javascript" #+clj "Failing on jvm"
    (is (= (ae/broken-identity-function "FOO") "FOO"))))

#+cljs (do
         (enable-console-print!)
         (t/test-ns 'aether.core-test))
