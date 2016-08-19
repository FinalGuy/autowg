(ns autowg.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [autowg.routes.home :refer [home-routes]]
            [ragtime.repl :as ragtime]
            [autowg.models.db :as db]))

(defn init []
  (println "autowg is starting")
  (ragtime/migrate db/config))

(defn destroy []
  (println "autowg is shutting down"))

(defroutes app-routes
           (route/resources "/")
           (route/not-found "Not Found"))

(def app
  (-> (routes home-routes app-routes)
      (handler/site)
      (wrap-base-url)))
