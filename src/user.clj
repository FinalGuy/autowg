(ns user
  (:require [ragtime.jdbc :as jdbc]))

(def config
  {:datastore  (jdbc/sql-database {:dbtype "postgres" :dbname "autowg" :host "localhost" :port 5432})
   :migrations (jdbc/load-resources "migrations")})
