#!/usr/bin/env bash

# At some point, I moved a repository from one machine to another, by transporting it as a tar.bz2
# When I extract it, I didn't preserve the original file parameters (thanks MC for the option)
# So git found files with now permission 644 instead of 755
#
# This script iterates over the files that appear changed and sets them the
# permissions that git has, overriding whatever the filesystem holds now

for f in $(git status -s | awk '{ print $2 ; }')
do 
    gitPermissions=$(git ls-files -s "$f" | awk '{ print $1 }' | sed -e 's/^100//')
    statPermissions=$(stat -c "%a" "$f")
    echo "$f git=$gitPermissions stat=$statPermissions" 

    if [[ -n $gitPermissions ]]
    then
        chmod $gitPermissions "$f"
    fi

    echo "" 
done

