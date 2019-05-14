#! /bin/bash

git add .

commit=$1
echo "commit message: $commit"
git commit -m "$commit"

git push
