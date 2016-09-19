(ns autowg.models.db
  (:require [clojure.java.jdbc :as jdbc]))

(def db {:dbtype   "postgresql"
         :dbname   "autowg"
         :host     "localhost"
         :user     "clojure"
         :password "clojure"})



(defn create-trips-table []
  (def result (jdbc/query db ["SELECT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_schema = 'public' AND table_name = 'trips');"]))
  (if (get (first result) :exists)
    (println "Tabelle existiert bereits")
    (jdbc/db-do-commands db (jdbc/create-table-ddl :trips
                                                   [[:id :serial :primary :key]
                                                    [:driver :text]
                                                    [:mileage :integer]
                                                    [:timestamp :timestamp :default :current_timestamp]]))))

(defn save-trip [driver mileage]
  (jdbc/insert! db :trips {:driver driver :mileage (read-string mileage)}))



