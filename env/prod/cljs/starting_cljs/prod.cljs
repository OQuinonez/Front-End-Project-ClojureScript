(ns starting-cljs.prod
  (:require
    [starting-cljs.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
