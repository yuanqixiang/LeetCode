/**************************KMP**********************************/
class Solution {
    //next[k] = j 表示P[k]之前的子串中，存在长度为j的相同前后缀
    vector<int> getNext(string& needle)
    {
        int len = needle.length();
        vector<int> next(len, 0);
        next[0] = 0;
        int j;
        int k = 0;
        for(j = 1; j < len; ++j)
        {
            if(k > 0 && needle[j] != needle[k])
                k = next[k - 1];
            if(needle[j] == needle[k])
                ++k;
            next[j] = k;
        }
        return next;
    }
public:
    int strStr(string haystack, string needle) {
        int len1 = haystack.size(), len2 = needle.size();
        if(len2 == 0) return 0;
        vector<int> next(len2, 0);
        next = getNext(needle);
        int i = 0, j = 0;
        while(i < len1 && j < len2)
        {
            if(haystack[i] == needle[j])
            {
                ++i;
                ++j;
            }
            else if(j > 0)
                j = next[j - 1];
            else
                ++i;
        }
        
        if(j == len2)
            return i - j;
        else
            return -1;
            
        }
};

/**********************************BRUTE FORCE*****************************************/

class Solution {
public:
    int strStr(string haystack, string needle) {
        int i = 0, j = 0;
        int len1 = haystack.size(), len2 = needle.size();
        if(len2 == 0) return 0;
        
        while(i < len1 && j < len2)
        {
            while(i < len1 && haystack[i] != needle[j]) ++i;
            
            if(i == len1) return -1;
            int pos = i;
            while(i < len1 && j < len2 && haystack[i] == needle[j])
            {
                ++i;
                ++j;
            }
            
            if(j == len2)
                return pos;
                
            if(i < len1 && j < len2)
            {
                i = pos + 1;
                j = 0;
                while(i < len1 && haystack[i] != needle[j]) ++i;
            }
        }
        return -1;
    }
};

//solution2
int strStr(string haystack, string needle) 
{
    int len1 = haystack.size(), len2 = needle.size();
    int i = 0, j = 0;
    while(i < len1 && j < len2)
    {
        if(haystack[i] == needle[j])
        {
            ++i;
            ++j;
        }
        else
        {
            i = i - j + 1;
            j = 0;
        }
    }
    if(j == len2)
        return i - j;
    else
        return -1;
}

//solution3
int strStr(string haystack, string needle) {
        int len1 = haystack.size(), len2 = needle.size();
    int i = 0, j = 0;
    while(i < len1 && j < len2)
    {
        if(haystack[i] == needle[j])
        {
            ++i;
            ++j;
        }
        else
        {
            i = i - j + 1;
            j = 0;
            while(i < len1 && haystack[i] != needle[j]) ++i;
        }
    }
    
    if(j == len2)
        return i - j;
    else
        return -1;
    }
