(ns autowg.models.db
  (:require [clojure.java.jdbc :as sql]))

(def db {:subprotocol "postgresql" :subname "//localhost/autowg" :user "clojure" :password "clojure"})

(defn create-trips-table []
  (sql/with-connection
    db
    (sql/create-table
      :trips
      [:id "varchar(32) PRIMARY KEY"]
      [:mileage "integer"]
      )))