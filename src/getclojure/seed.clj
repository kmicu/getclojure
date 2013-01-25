(ns getclojure.seed
  (:use [getclojure.search :only (create-getclojure-index add-to-index)]
        [clojurewerkz.elastisch.rest :only (connect!)])
  (:require [clojure.java.io :as io]))

(def sexps
  (into #{} (read-string (slurp (io/file "working-sexps.db")))))

(defn add-sexps-to-index []
  (doseq [sexp sexps]
    (print ".")
    (add-to-index :getclojure_development sexp)))

(defn -main []
  (println "Attempting to connect to searchbox...")
  (println "The Bonsai URL is" (System/getenv "BONSAI_URL"))
  (connect! (or (System/getenv "BONSAI_URL")
                "http://127.0.0.1:9200"))
  (create-getclojure-index)
  (println "Adding sexps to the index...")
  (time (add-sexps-to-index)))