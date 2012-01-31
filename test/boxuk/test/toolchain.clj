
(ns boxuk.test.toolchain
  (:use boxuk.toolchain
        clojure.test))

(deftest test-check-binaries-when-exists
    (is (check-binaries ["sh"])))

(deftest test-check-binaries-throws-error
    (is (thrown? Exception (check-binaries ["qkashjs"]))))

(deftest test-check-binary-when-exists
    (is (nil? (check-binary "sh"))))

(deftest test-check-binary-throws-error
    (is (thrown? Exception (check-binary "ksbrmss"))))

(deftest test-has-binaries
    (is (true? (has-binaries? ["sh"])))
    (is (false? (has-binaries? ["sadashjk"]))))

(deftest test-has-binary
    (is (true? (has-binary? "sh")))
    (is (false? (has-binary? "shdkjwhd"))))

