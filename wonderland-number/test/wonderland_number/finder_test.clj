(ns wonderland-number.finder-test
  (:require [clojure.test :refer :all]
            [wonderland-number.finder :refer :all]))

(defn hasAllTheSameDigits? [n1 n2]
  (let [s1 (set (str n1))
        s2 (set (str n2))]
    (= s1 s2)))

(deftest test-wonderland-number
  (testing "A wonderland number must have the following things true about it"
    (let [wondernum (wonderland-number)]
      (is (= 6 (count (str wondernum))))
      (is (hasAllTheSameDigits? wondernum (* 2 wondernum)))
      (is (hasAllTheSameDigits? wondernum (* 3 wondernum)))
      (is (hasAllTheSameDigits? wondernum (* 4 wondernum)))
      (is (hasAllTheSameDigits? wondernum (* 5 wondernum)))
      (is (hasAllTheSameDigits? wondernum (* 6 wondernum))))))

(deftest test-is-six-digits
  (testing "Helper function to decide if number is six digits"
    (is (= true (is-six-digits? 123456)))
    (is (= false (is-six-digits? 12345)))
    (is (= false (is-six-digits? 1234567)))))

(deftest test-has-same-digits?
  (testing "Helper function to decide if the set of digit are the same"
    (is (= true (has-same-digits? 123456 345612)))
    (is (= false (has-same-digits? 123456 234567)))))
