(ns starting-cljs.core
    (:require
      [reagent.core :as r]))

;; -------------------------
;; Views
(defn foo []
  [:p "hello World"]
  (let [bar "Hello, I work"]))

; BELOW, WE WILL HAVE AN EMPTY ARRAY, WHICH WILL WORK AS THE CART
(def cart (array))


; --------------------- DISPLAYING ITEMS -------------
; HOW TO DISPLAY ITEMS AND HAVE AN INDIVIDUAL CLASS FOR EACH ITEM
; FIRST YOU ORGANIZE YOUR DATA OF THE ITEMS HOWEVER YOU WANT IT
; BELOW, WE WILL MAKE THE INVENTORY OF THE STORE
(def store 
  (r/atom
    {:message "Welcome to the Wireless O"
    :items [{
                :name "Bose SoundLink Color Bluetooth speaker II soft black"
                :description "Voice prompts talk you through Bluetooth pairing so it’s easier than ever—or even quick-pair with NFC devices,lets you enjoy up to 8 hours of play time"
                :price 129.0
                :quantity 8
                :img "https://images.crutchfieldonline.com/ImageHandler/trim/620/378/products/2016/36/018/g018SLCR2B-F.jpg"
                :seller "O Party Room"}
                {
                :name "DJ Black-24BLB 24 inch UV Black Pro Blacklight"
                :description "Package comes with two American DJ Black-24BLB 2 Foot Black Lights that are made of durable and high quality material."
                :price 39.98
                :quantity 10
                :img "https://images-na.ssl-images-amazon.com/images/I/41lZed26lXL._SX300_.jpg"
                :seller "O Party Room"}]}))

(defn actually-buy [store-map item-index]
  (update-in store-map [:items item-index :quantity] dec))

(defn buy-item [item-index]
  (swap! store actually-buy item-index))

(defn buy-button [item-index]
  [:button.btn
    {:on-click (fn [] (buy-item item-index))}
    "Buy!"])

; FUNCTION FOR LOOPS THROUGH EVERY ITEM IN ORDER TO DISPLAY CORRECTLY
; IT IS CALLED ON LINE 65
(defn displaying [items]
  [:div {:class "store-items"}
    (map-indexed
      (fn [item-index item]
        [:div.row
          [:div.col-lg-6.col-md-6.col-sm-4.Items
            [:img {:src (:img item)}]
            [:p "Name: "(:name item)]
            [:strong "Description: "][:p (:description item)]
            [:p "Price: "(:price item)]
            [:p "Quantity: "(:quantity item)]]
            [buy-button item-index]])
      items)])

    
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
  [:div {:class "row"}
    [:div {:class "col-lg-4 col-md-6 col-sm-4 Header"}]]
    [:h1 (:message @store)]
  ; FUNCTION CALL BELOW!!!!!!!
  [displaying (:items @store)]])


;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
