#! /bin/bash

git add .

commit=$1
echo "commit: $commit"
git commit -m "$commit"

git push
