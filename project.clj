(defproject aether "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :jar-exclusions [#"\.cljx|\.swp|\.swo|\.DS_Store"]
  :source-paths ["src/cljx"]
  :test-paths ["target/test-classes"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [formative "0.8.8"]]

  :cljx {:builds [{:source-paths ["src/"]
                   :output-path "target/classes"
                   :rules :clj}

                  {:source-paths ["src/"]
                   :output-path "target/generated/cljs"
                   :rules :cljs}

                  {:source-paths ["test/"]
                   :output-path "target/test-classes"
                   :rules :clj}

                  {:source-paths ["test/"]
                   :output-path "target/test-classes"
                   :rules :cljs}]}

  :cljsbuild {:test-commands {"node" ["node"  :node-runner "target/testable.js"]}
              :builds [{:source-paths ["target/classes" "target/test-classes"]
                        :compiler {:output-to "target/testable.js"
                                   :optimizations :advanced
                                   :pretty-print true}}
                       {:source-paths ["target/generated/cljs" "target/test-classes"]
                        :compiler {:output-to "resources/public/main.js"
                                   :optimizations :advanced
                                   :pretty-print true}}]}

  :profiles {:dev {:plugins [[org.clojure/clojurescript "0.0-2156"]
                             [com.keminglabs/cljx "0.3.2"]
                             [lein-cljsbuild "1.0.1"]
                             [com.cemerick/clojurescript.test "0.2.2"]]
                   :dependencies [[org.clojure/clojurescript "0.0-2156"]]
                   :hooks [cljx.hooks]
                   :aliases {"cleantest" ["do" "clean," "cljx" "once," "test,"
                                          "cljsbuild" "test"]
                             "deploy" ["do" "clean," "cljx" "once,"
                                       "deploy" "clojars"]}}})
