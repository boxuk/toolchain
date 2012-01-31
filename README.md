
# Toolchain

Toolchain is a simple tool for checking the system setup for required components.

## Usage

To check that some binaries are installed just use the *check-binaries* function.

```clojure
(:use boxuk.toolchain)

(check-binaries ["git" "lein"])
```

This will throw an exception if any of the binaries are not installed.

## License

Dual licensed under GPLv2 and MIT.

