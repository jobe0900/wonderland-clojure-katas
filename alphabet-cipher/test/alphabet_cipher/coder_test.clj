(ns alphabet-cipher.coder-test
  (:require [clojure.test :refer :all]
            [alphabet-cipher.coder :refer :all]))

(deftest test-generate-string
  (testing "produce a string starting on character"
    (is (= "abcdefghijklmnopqrstuvwxyz"
           (generate-string-for-char \a)))
    (is ( = "qrstuvwxyzabcdefghijklmnop"
           (generate-string-for-char \q)))))

(deftest test-lower-case-char
  (testing "convert a char to lower case"
    (is (= \a (lower-case-char \A)))
    (is (= \b (lower-case-char \b)))))

(deftest test-key-string 
  (testing "generate a string of a length from the keyword"
    (is (= "sconessconessco"
           (generate-key-string "scones" (count "meetmebythetree"))))))

(deftest test-encode-char
  (testing "encoding a single char"
    (is (= \e (encode-char \s \m)))))

(deftest test-encode
  (testing "can encode given a secret keyword"
    (is (= "hmkbxebpxpmyllyrxiiqtoltfgzzv"
           (encode "vigilance" "meetmeontuesdayeveningatseven")))
    (is (= "egsgqwtahuiljgs"
           (encode "scones" "meetmebythetree")))))

(deftest test-decode-char
  (testing "ecoding a single char"
    (is (= \m (decode-char \s \e)))))

(deftest test-decode
  (testing "can decode an cyrpted message given a secret keyword"
    (is (= "meetmeontuesdayeveningatseven"
           (decode "vigilance" "hmkbxebpxpmyllyrxiiqtoltfgzzv")))
    (is (= "meetmebythetree"
           (decode "scones" "egsgqwtahuiljgs")))))

;(deftest test-decipher
  ;(testing "can extract the secret keyword given an encrypted message and the original message"
    ;(is (= "vigilance"
           ;(decipher "opkyfipmfmwcvqoklyhxywgeecpvhelzg" "thequickbrownfoxjumpsoveralazydog")))
    ;(is (= "scones"
           ;(decipher "hcqxqqtqljmlzhwiivgbsapaiwcenmyu" "packmyboxwithfivedozenliquorjugs")))))
