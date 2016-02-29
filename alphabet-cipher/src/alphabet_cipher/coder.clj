(ns alphabet-cipher.coder)

(def letters "abcdefghijklmnopqrstuvwxyz")

;; Turn all letters to lowercase. 
;; No checking, meant to be used here for a-z,A-Z
(defn lower-case-char [ch]
  (if (> (int \a) (int ch))
    (char (+ (int \a) 
             (- (int ch) (int \A))))
    ch))

;; Generate a string of all lowercase letters, starting at ch
;; and wrapping from 'z' to 'a'
(defn generate-string-for-char [ch]
  (let [n (.indexOf letters (str ch))]
    (apply str (concat (drop n letters) (take n letters)))))

;; Generate a string of the correct length by repeating the keyword
;; if necessary.
(defn generate-key-string [kw len]
  (let [reps (int (Math/ceil (/ len (count kw))))] 
    (apply str (take len (apply str (repeat reps kw))))))

;; Encode a single char m using k as encoding key
(defn encode-char [k m]
  (get (generate-string-for-char m) (.indexOf letters (str k))))

;; Encode a string using keyword
(defn encode [keyword message]
  (apply str (map encode-char 
                  (generate-key-string keyword (count message)) 
                  message)))

;; Decode a single char m using k as encoding key
(defn decode-char [k m]
  (get letters (.indexOf (generate-string-for-char k) (str m))))

;; Encode a string using keyword
(defn decode [keyword message]
  (apply str (map decode-char
                   (generate-key-string keyword (count message))
                   message)))

;; Find keyword char from a single char m with the cipher c
(defn decipher-char [c m]
  (get letters (.indexOf (generate-string-for-char m) (str c))))

;; Find the keyword that is repeated to make the keyword string.
(defn extract-keyword [kw-string]
  (loop [i 1]
    (if (< i (count kw-string))
      (let [sub (subs kw-string 0 i)]
        (if (= kw-string (apply str (take (count kw-string) (cycle sub))))
          sub
          (recur (inc i))))
      nil)))

;; Find the ccipher keyword from the encrypted and original message.
(defn decipher [cipher message]
  (let [kw-string (apply str (map decipher-char cipher message))]
    (extract-keyword kw-string)))

