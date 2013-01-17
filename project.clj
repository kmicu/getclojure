(defproject getclojure "0.1.0"
  :description "GetClojure"
  :url "http://getclojure.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [clojurewerkz/elastisch "1.0.2"]
                 [clojail "1.0.3"]
                 [org.clojars.semperos/enlive "1.0.1"
                  :exclusions [org.clojure/clojure]]
                 [me.raynes/laser "0.1.15"]
                 [org.clojure/data.csv "0.1.2"]
                 ;; Web
                 [lib-noir "0.3.5"]
                 [compojure "1.1.3"]
                 [hiccup "1.0.2"]
                 [ring-server "0.2.5"]
                 [com.taoensso/timbre "1.2.0"]
                 [com.taoensso/tower "1.2.0"]
                 [markdown-clj "0.9.19"]]
  :plugins [[lein-ring "0.8.0"]]
  :profiles
  {:production {:ring {:open-browser? false
                       :stacktraces?  false
                       :auto-reload?  false}}
   :dev {:dependencies [[ring-mock "0.1.3"]
                        [ring/ring-devel "1.1.0"]]}}
  :jvm-opts ["-Xmx2g" "-server"]
  :min-lein-version "2.0.0")
