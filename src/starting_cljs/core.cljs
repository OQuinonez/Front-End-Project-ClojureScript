(ns starting-cljs.core
    (:require
      [reagent.core :as r]))

;; -------------------------
;; Views

(defn home-page []
  ; [:div [:h2 "Welcome to the O Store!"]])
    [:div
   [:p "I am a component!"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red "] "text."]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
