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

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

