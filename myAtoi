//Implementation atoi to convert a string to an integer.
class Solution {
public:
    int myAtoi(string str) {
        bool isMinus=false;
        long long result=0;
        int len=str.size();
        //char* pstr=(char*)(&str);
        //if(pstr==nullptr)
        if(len==0)
            return 0;
        int i=0;
        while(isspace(str.at(i)))
              ++i; 
        if(str.at(i)=='-')
            { 
               isMinus=true;
               ++i;
            }
        else if(str.at(i)=='+') ++i;
        //else  return 0;
        
       while(i<len){
            if(str.at(i)>='0' && str.at(i)<='9'){
                result=result*10+(str.at(i)-'0');
                if(result>INT_MAX && !isMinus)
                 {
                     return INT_MAX;
                     break;
                 }
                 if((0-result)<INT_MIN && isMinus)
                 {
                     return INT_MIN;
                     break;
                 }
                //pstr++;
                ++i;
            }
            else{
                //return 0;
                break;
            }
        }
        if(isMinus)
           result=0-result;
        return result;
    }
};
