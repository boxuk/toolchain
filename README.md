
# Toolchain

Toolchain is a simple tool for checking the system setup for required components.

## Usage

To check that some binaries are installed just use the *check-binary* and *check-binaries*
functions.

```clojure
(:use boxuk.toolchain)

(check-binary "svn")
(check-binaries ["git" "lein"])
```

These will throw an exception if any of the binaries are not installed.  Alternatively if
you're just interested in booleans then you can use the *has-binary?* and *has-binaries?*
functions.

```clojure
(has-binary? "svn")
(has-binaries? ["svn" "something-else"])
```

Which return true/false instead of throwing an Exception.

## License

Dual licensed under GPLv2 and MIT.

