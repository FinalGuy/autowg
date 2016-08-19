(ns autowg.models.db
  (:require [ragtime.jdbc :as jdbc]))

(def db {:subprotocol "postgresql" :subname "//localhost/autowg" :user "clojure" :password "clojure"})

(def config
  {:datastore  (jdbc/sql-database {:connection-uri "jdbc:postgresql://localhost/autowg?user=clojure&password=clojure"})
   :migrations (jdbc/load-resources "migrations")})
