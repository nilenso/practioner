(defproject practitioner "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [ring/ring-core          "1.9.6"]
                 [ring/ring-jetty-adapter "1.9.6"]
                 [org.postgresql/postgresql "42.2.10"]
                 [com.github.seancorfield/next.jdbc "1.3.828"]
                 [bidi "2.1.6"]
                 [aero "1.1.6"]
                 [migratus "1.4.4"]
                 [mount "0.1.16"]
                 [hiccup "1.0.5"]]
  :resource-paths ["config"]
  :main ^:skip-aot practitioner.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-D clojure.compiler.direct-linking=true"]}})
