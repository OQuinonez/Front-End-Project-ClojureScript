(ns ^:figwheel-no-load starting-cljs.dev
  (:require
    [starting-cljs.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
