(ns autowg.routes.home
  (:require [compojure.core :refer :all]
            [autowg.views.layout :as layout]
            [autowg.models.db :as db]))

(defn show-alert [message]
  [:div {:class "alert alert-success alert-dismissible" :role "alert"}
   [:button {:type "button" :class "close" :data-dismiss "alert" :aria-label "Close"}
    [:span {:aria-hidden "true"} "&times;"]]
   [:strong message]])


(defn form []
  [:form.form-horizontal {:role "form" :method "post"}
   [:div.form-group
    [:label.control-label.col-sm-2 {:for "stand"} "Kilometerstand:"]
    [:div.col-sm-10
     [:input#stand.form-control {:type "number" :name "stand"}]]]
   [:div.form-group
    [:label.control-label.col-sm-2 {:for "fahrer"} "Fahrer:"]
    [:div.col-sm-10
     [:select#fahrer.form-control {:name "fahrer"}
      [:option "Sonja & Torben"]
      [:option "Jessica & Nils"]
      ]]]
   [:div.form-group
    [:div.col-sm-offset-2.col-sm-10
     [:input.btn.btn-success {:type "submit" :value "eintragen"}]]]])


(defn home [alert]
  (layout/common
    [:div.container
     [:div.jumbotron
      [:div.container
       [:h1 "Hallo"]
       [:p.lead "Hier können wir die Kilometer aufschreiben"]]]
     alert
     ; Hier beginnt das Panel
     [:div.panel.panel-success
      [:div.panel-heading
       [:h3 "Kilometerstand eintragen"]]
      [:div.panel-body
       (form)]]
     ]))

(defn neuer-eintrag [stand fahrer]
  (println (str "stand: " stand))
  (println (str "Fahrer: " fahrer))
  (db/save-trip fahrer stand)
  (home (show-alert "erfolgreich gespeichert")))

(defroutes home-routes
           (GET "/" [] (home ""))
           (POST "/" [stand fahrer] (neuer-eintrag stand fahrer)))
