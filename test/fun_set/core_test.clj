(ns fun-set.core-test
  (:require [clojure.test :refer :all]
            [clojure.set :as set]
            [fun-set.core :refer :all]))

(defn rand-elements [num-els]
  (repeatedly num-els #(rand-int 100)))

(deftest empty-set-test
  (is (= nil (empty-set 1)))
  (is (= nil (empty-set false)))
  (is (= nil (empty-set "test"))))

(deftest singleton-set-test
  (let [f-set (singleton-set :success)]
    (is (= nil (f-set 1)))
    (is (= nil (f-set false)))
    (is (= nil (f-set "test")))
    (is (= :success (f-set :success)))))

(deftest f-contains-test
  (let [f-set1 (singleton-set :success)
        f-set2 (singleton-set false)]
    (is (= true (f-contains? f-set1 :success)))
    (is (= true (f-contains? f-set2 false)))
    (is (= false (f-contains? f-set1 :fail)))
    (is (= false (f-contains? f-set2 true)))))

(deftest union-test
  (testing "base cases"
    (let [f-set1 (singleton-set :test1)
          f-set2 (singleton-set :test2)
          u-set (union f-set1 f-set2)]
      (is (= nil (u-set 1)))
      (is (= nil (u-set false)))
      (is (= nil (u-set "test")))
      (is (= :test1 (u-set :test1)))
      (is (= :test2 (u-set :test2)))))
  (testing "true false sets"
    (let [f-set1 (singleton-set false)
          f-set2 (singleton-set true)
          u-set1 (union f-set1 f-set2)
          u-set2 (union f-set2 f-set1)]
      (is (= false (u-set1 false)))
      (is (= false (u-set2 false))))))

(deftest union-all-test
  (let [els (rand-elements 50)
        f-set (->> els
                   (map singleton-set)
                   (apply union-all))
        c-set (into #{} els)]
    (doseq [el (range 100)]
      (is (= (f-set el) (c-set el))))))

(deftest intersection-test
  (testing "overlap of sets"
    (let [f-set1 (singleton-set :test1)
          f-set2 (singleton-set :test1)
          i-set (intersection f-set1 f-set2)]
      (is (= nil (i-set 1)))
      (is (= nil (i-set false)))
      (is (= nil (i-set "test")))
      (is (= :test1 (i-set :test1)))))
  (testing "no overlap of sets"
    (let [f-set1 (singleton-set :test1)
          f-set2 (singleton-set :test2)
          i-set (intersection f-set1 f-set2)]
      (is (= nil (i-set 1)))
      (is (= nil (i-set false)))
      (is (= nil (i-set "test")))
      (is (= nil (i-set :test1)))
      (is (= nil (i-set :test2)))))
  (testing "true false sets"
    (let [f-set1 (singleton-set false)
          f-set2 (singleton-set true)
          i-set1 (intersection f-set1 f-set2)
          i-set2 (intersection f-set2 f-set1)]
      (is (= nil (i-set1 false)))
      (is (= nil (i-set2 false))))
    (let [f-set1 (singleton-set false)
          f-set2 (singleton-set false)
          i-set1 (intersection f-set1 f-set2)
          i-set2 (intersection f-set2 f-set1)]
      (is (= false (i-set1 false)))
      (is (= false (i-set2 false))))))


(deftest intersection-all-test
  (testing "base case"
    (let [els1 (rand-elements 100)
          els2 (rand-elements 100)
          els3 (rand-elements 100)
          f-set (intersection-all (->> els1
                                       (map singleton-set)
                                       (apply union-all))
                                  (->> els2
                                       (map singleton-set)
                                       (apply union-all))
                                  (->> els3
                                       (map singleton-set)
                                       (apply union-all)))
          c-set (->> [els1 els2 els3]
                     (map #(into #{} %))
                     (apply set/intersection))]
      (doseq [el (range 100)]
        (is (= (f-set el) (c-set el))))))
  (testing "no args returns empty set"
    (let [res (intersection-all)]
      (is (identical? res empty-set)))))

(deftest f-conj-test
  (let [els (rand-elements 50)
        f-set (reduce f-conj empty-set els)
        c-set (into #{} els)]
    (doseq [el (range 100)]
      (is (= (f-set el) (c-set el))))))

(deftest f-disj-test
  (let [els (rand-elements 50)
        base-set (reduce f-conj empty-set els)
        f-set (reduce f-disj base-set (take 25 els))
        c-set (reduce disj (into #{} els) (take 25 els))]
    (doseq [el (range 100)]
      (is (= (f-set el) (c-set el))))))

(deftest f-set-test
  (let [els (rand-elements 50)
        f-set (apply f-set els)
        c-set (into #{} els)]
    (doseq [el (range 100)]
      (is (= (f-set el) (c-set el))))))
