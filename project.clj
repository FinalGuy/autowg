(defproject autowg "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [org.postgresql/postgresql "9.2-1002-jdbc4"]
                 [org.clojure/java.jdbc "0.6.2-alpha2"]
                 ;;[org.clojure/java.jdbc "0.2.3"]
                 ]
  :plugins [[lein-ring "0.8.12"]]
  :ring {:handler autowg.handler/app
         :init    autowg.handler/init
         :destroy autowg.handler/destroy}
  :profiles
  {:uberjar {:aot :all}
   :production
            {:ring
             {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
            {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.1"]]}})
