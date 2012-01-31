
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

(defn- check-binary
    "Check that a specified binary is on the PATH"
    [binary]
    (some true?
        (map (partial binary-exists-at? binary) 
             (path-components))))

;; Public

(defn check-binaries
    "Checks the system for required binaries available on the PATH"
    [binaries]
    (doseq [binary binaries]
        (if (not (check-binary binary))
            (throw (Exception. (str binary " not found..."))))))

