
(ns boxuk.toolchain
    (:import (java.io File))
    (:require [clojure.string :as string]))

(defn- path-components
    "Returns a vector of PATH components"
    []
    (string/split (System/getenv "PATH") #":"))

(defn- binary-exists-at?
    "Check if the specified binary exists at the path"
    [binary path]
    (.exists (File. (str path "/" binary))))

;; Public

(defn has-binary?
    "Returns true if a binary is on the PATH, nil otherwise."
    [binary]
    (boolean (some true? (map (partial binary-exists-at? binary) 
                              (path-components)))))

(defn has-binaries?
    "Returns true if all binaries exist, false otherwise."
    [binaries]
    (every? true?
        (map has-binary? binaries)))

(defn check-binary
    "Check that a specified binary is on the PATH, throwing an Exception if
     it doesn't."
    [binary]
    (if (not (has-binary? binary))
        (throw (Exception. (str binary " not found")))))

(defn check-binaries
    "Checks the system for required binaries available on the PATH, throws an
     Exception if any are missing."
    [binaries]
    (doall (map check-binary binaries)))

