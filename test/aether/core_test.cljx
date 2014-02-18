(ns aether.core-test
  #+cljs (:require-macros [cemerick.cljs.test
                           :refer [is are deftest testing run-tests]]
                          [formative.macros :refer [with-fallback]])
  (:require [formative.parse :as fp]
            [formative.util :as fu]
            [aether.core :as ae]
            #+clj [formative.parse :refer [with-fallback]]
            #+cljs [cemerick.cljs.test :as t]
            #+clj [clojure.test :refer [is are deftest testing run-tests]]))


(deftest a-test
  (testing #+cljs "Failing in javascript" #+clj "Failing on jvm"
    (is (= (ae/broken-identity-function "FOO") "FOO"))))

(def demo-form-good-params
  {"full-name" "Somebody Somewhere"
   "user[email]" "something@mailinator.com"
   "spam" "false"})

(def demo-form-bad-params
  {:name "Somebody Somewhere"})

(def good-parsed-values
  {:full-name "Somebody Somewhere"
   :user {:email "something@mailinator.com"}
   :spam false})

(deftest demo-form-test
  (testing #+cljs "Failing in javascript" #+clj "Failing on jvm"
    (let [values (fp/parse-params ae/demo-form demo-form-good-params)]
      (is (= values good-parsed-values)))))

#+cljs (do
         (enable-console-print!)
         (t/test-ns 'aether.core-test))
