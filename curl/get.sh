#!/usr/bin/env bash

# --trace-ascii <fileName> - dump trace into file
# --cookie-jar <fileName> - file where to save and from where to load cookies
# -v - verbose
# -o <where to set output>
--location <url> - url to load (also it follows redirrects)
curl -v --cookie-jar cookies.txt \
    -o output.txt \
    --location 
