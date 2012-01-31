
(ns boxuk.test.toolchain
  (:use boxuk.toolchain
        clojure.test))

(deftest test-check-binaries-when-exists
    (is (nil? (check-binaries ["sh"]))))

(deftest test-check-binaries-throws-error
    (is (thrown? Exception (check-binaries ["qkashjs"]))))

