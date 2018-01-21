(ns starting-cljs.core
    (:require
      [reagent.core :as r]))

;; -------------------------
;; Views
(defn foo []
  [:p "hello World"]
  (let [bar "Hello, I work"]))


; --------------------- DISPLAYING ITEMS -------------
; HOW TO DISPLAY ITEMS AND HAVE AN INDIVIDUAL CLASS FOR EACH ITEM
; FIRST YOU ORGANIZE YOUR DATA OF THE ITEMS HOWEVER YOU WANT IT
(def store 
  (r/atom
    {:message "Welcome to the Wireless O"
    :items [{:display "Item 1"}
            {:display "Item 2"}
            {:display "Item 3"}
            {:display "Item 4"}]}))

; FUNCTION FOR LOOPS THROUGH EVERY ITEM IN ORDER TO DISPLAY CORRECTLY
; IT IS CALLED ON LINE 65
(defn displaying [items]
  [:div {:class "store-items"}
    (for [item items]
      [:div {:class "item"}
      [:p (:display item)]])])
    
(defn home-page []
  ; [:div [:h2 "Welcome to the O Store!"]])

; THIS IS HOW YOU ADD CLASSES   
;   [:div {:class "Example"}
  ;  [:p "I am a Osvaldo!"]
  ;  [:p [foo]]
  ;  [:p.someclass
  ;   "I have " [:strong "bold"]
  ;   [:span {:style {:color "red"}} " and red "] "text."]])

; -------------------- ATOMS !!!! -----------------
; (def msg 
;   (r/atom 
;     {:message "Hello From Msg Function"}))
; ATOMS ARE MUTABLE DATA STRUCTURES r/atom CHECK YOUR IMPORTS 

; ---------- IF STATEMENT...COULD HELP WITH THE PURCHASE BUTTON -------------
  ; [:div {}
    ; (if (> 5 8)
    ; [:p "Statement was true"]
    ; [:p "Statement was not true"])
; ------- LOOK AT THE @ SYMBOL!  IT COMES FROM THE FUNCTION RIGHT BELOW THE COMMENT ATOMS
    ; [:p (:message @msg)]])
  
; ----------- BASIC FOR LOOP -------------
  ; [:div {}
  ;   (for [i (range 10)]
  ;     [:h1 i])])

; ----- I GO WITH DISPLAYING ITEMS ------




[:div {:class "container"}
  [:h1 (:message @store)]
  ; FUNCTION CALL BELOW!!!!!!!
  [displaying (:items @store)]])


;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
