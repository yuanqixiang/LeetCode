#! /bin/bash
if [ $# != 2 ] ; then 
    echo "USAGE: $0 file_name commit_message" 
    echo "e.g.: $0 file.java \"some info\"" 
    exit 1; 
fi 

file_name=$1
if  [ ! -n "$file_name" ] ;then
    echo "no file is appointed"
else
    echo "git add $file_name"
fi

git add $file_name

commit_message=$2
if  [ ! -n "$commit_message" ] ;then
    echo "no commit message"
else    
    echo "commit message: $commit_message"
fi

git commit -m "$commit_message"

git push
