(ns autowg.routes.home
  (:require [compojure.core :refer :all]
            [autowg.views.layout :as layout]))

;<div class="jumbotron">
;<h1>Jumbotron heading</h1>
;<p class="lead"> sit amet risus.</p>
;<p><a class="btn btn-lg btn-success" href="#" role="button">Sign up today</a></p>
;</div>

(defn home []
  (layout/common
    [:div {:class "container"}
     [:div {:class "header clearfix"}
      [:div {:class "jumbotron"}
       [:h1 "Hallo"]
       [:p {:class "lead"} "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo"]
       ]]]))

(defroutes home-routes
           (GET "/" [] (home)))
