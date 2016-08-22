(ns autowg.models.db
  (:require [ragtime.jdbc :as ragtime]
            [clojure.java.jdbc :as jdbc]))

(def db {:subprotocol "postgresql" :subname "//localhost/autowg" :user "clojure" :password "clojure"})

(def config
  {:datastore  (ragtime/sql-database {:connection-uri "jdbc:postgresql://localhost/autowg?user=clojure&password=clojure"})
   :migrations (ragtime/load-resources "migrations")})

(defn save-trip [driver mileage]
  (jdbc/insert! db :trips {:driver driver :mileage (read-string mileage)}))
