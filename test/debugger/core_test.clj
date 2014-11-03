(ns debugger.core-test
  (:require [clojure.test :refer :all]
            [clojure.walk :refer [postwalk-demo]]
            [debugger.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(def wow 1)

(defn foo [& args]
  (let [a [1 2]
        b #{3 4}
        c {:k "v"}
        d nil
        e (fn [] nil)
        x "world"
        y '(8 9)
        z (Object.)
        ret (break (inc 42))]
    (println "Exit foo with" ret)))

(defn bar [multi]
  (let [my-fn (dbg (break (fn inner [x] (* multi x))))]
    (map my-fn (range 2))))

(defn qux [multi]
  (let [my-fn (fn inner [x] (break (* multi x)))]
    (map my-fn (range 2))))
