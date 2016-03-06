(ns wonderland-number.finder)

(defn is-six-digits? [x]
  (= (count (str x)) 6))

(defn has-same-digits? [a b]
  (= (set (str a)) (set (str b))))

(defn fulfills-number-condition [x]
  (and (is-six-digits x)
       (has-same-digits? x (* 2 x))
       (has-same-digits? x (* 3 x))
       (has-same-digits? x (* 4 x))
       (has-same-digits? x (* 5 x))
       (has-same-digits? x (* 6 x))))

(defn wonderland-number []
  (loop [x 100000]
    (if (fulfills-number-condition x)
      x
      (if (>= x 999999)
        nil
        (recur (inc x))))))

;; Day 4
;; Special number under 1000 that equals the sum of the cubes of the digits

(defn cube [x]
  (* x x x))

(defn sum [s]
  (reduce + s))

;; Sum the cubes of the digits in x
(defn sum-cubes [x]
  (sum (map cube (map #(read-string (str %)) (str x)))))

(defn numbers-equals-sum-of-cubes []
  (loop [n 1000
         nrs []]
    (if (<= n 0)
      nrs
      (recur (dec n)
             (if (= n (sum-cubes n))
               (conj nrs n)
               nrs)))))

