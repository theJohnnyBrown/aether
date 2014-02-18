(ns cljxweb.core-test
  #+cljs (:require-macros [cemerick.cljs.test
                           :refer [is are deftest testing run-tests]])
  (:require [cljxweb.core :as cw]
            #+cljs [cemerick.cljs.test :as t]
            #+clj [clojure.test :refer [is are deftest testing run-tests]]))


(deftest a-test
  (testing #+cljs "Failing in javascript" #+clj "Failing on jvm"
    (is (= (cw/broken-identity-function "FOO") "FOO"))))

#+cljs (do
         (enable-console-print!)
         (t/test-ns 'cljxweb.core-test))
