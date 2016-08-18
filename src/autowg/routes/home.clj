(ns autowg.routes.home
  (:require [compojure.core :refer :all]
            [autowg.views.layout :as layout]))

(defn show-alert [message]
  [:div {:class "alert alert-success alert-dismissible" :role "alert"}
   [:button {:type "button" :class "close" :data-dismiss "alert" :aria-label "Close"}
    [:span {:aria-hidden "true"} "&times;"]]
   [:strong message]])


(defn form []
  [:form {:role "form" :class "form-horizontal" :method "post"}
   [:div {:class "form-group"}
    [:label {:for "stand" :class "control-label col-sm-2"} "Kilometerstand:"]
    [:div {:class "col-sm-10"}
     [:input {:type "number" :class "form-control" :id "stand" :name "stand"}]]]
   [:div {:class "form-group"}
    [:label {:for "fahrer" :class "control-label col-sm-2"} "Fahrer:"]
    [:div {:class "col-sm-10"}
     [:select {:class "form-control" :id "fahrer" :name "fahrer"}
      [:option "Sonja & Torben"]
      [:option "Jessica & Nils"]
      ]]]
   [:div {:class "form-group"}
    [:div {:class "col-sm-offset-2 col-sm-10"}
     [:input {:type "submit" :class "btn btn-success" :value "eintragen"}]]]])


(defn home [alert]
  (layout/common
    [:div {:class "container"}
     [:div {:class "jumbotron"}
      [:div {:class "container"}
       [:h1 "Hallo"]
       [:p {:class "lead"} "Hier können wir die Kilometer aufschreiben"]]]
     alert
     ; Hier beginnt das Panel
     [:div {:class "panel panel-success"}
      [:div {:class "panel-heading"}
       [:h3 "Kilometerstand eintragen"]]
      [:div {:class "panel-body"}
       (form)]]
     ]))

(defn neuer-eintrag [stand fahrer]
  (println (str "stand: " stand))
  (println (str "Fahrer: " fahrer))
  (home (show-alert "erfolgreich gespeichert")))

(defroutes home-routes
           (GET "/" [] (home ""))
           (POST "/" [stand fahrer] (neuer-eintrag stand fahrer)))
