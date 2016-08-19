(ns user
  (:require [ragtime.jdbc :as jdbc]))

(def config
  {:datastore  (jdbc/sql-database {:connection-uri "jdbc:postgresql://localhost/autowg?user=clojure&password=clojure"})
   :migrations (jdbc/load-resources "migrations")})
