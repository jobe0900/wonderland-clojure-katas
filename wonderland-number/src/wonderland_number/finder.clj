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
