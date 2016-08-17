(ns autowg.routes.home
  (:require [compojure.core :refer :all]
            [autowg.views.layout :as layout]))


(defn form []
  [:form {:role "form" :class "form-horizontal"}
   [:div {:class "form-group"}
    [:label {:for "stand" :class "control-label col-sm-2"} "Kilometerstand:"]
    [:div {:class "col-sm-10"}
     [:input {:type "number" :class "form-control" :id "stand"}]]]
   [:div {:class "form-group"}
    [:label {:for "fahrer" :class "control-label col-sm-2"} "Fahrer:"]
    [:div {:class "col-sm-10"}
     [:select {:class "form-control" :id "fahrer"}
      [:option "Sonja & Torben"]
      [:option "Jessica & Nils"]
      ]]]
   [:div {:class "form-group"}
    [:div {:class "col-sm-offset-2 col-sm-10"}
     [:button {:type "submit" :class "btn btn-success"} "eintragen"]]]])


(defn home []
  (layout/common
    [:div {:class "container"}
     [:div {:class "jumbotron"}
      [:div {:class "container"}
       [:h1 "Hallo"]
       [:p {:class "lead"} "Hier können wir die Kilometer aufschreiben"]]]
     [:div {:class "panel panel-success"}
      [:div {:class "panel-heading"}
       [:h3 "Kilometerstand eintragen"]]
      [:div {:class "panel-body"}
       (form)]]
     ]))

(defroutes home-routes
           (GET "/" [] (home)))
