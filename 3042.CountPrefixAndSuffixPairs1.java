01 .Using Substring
class Solution {
    public int countPrefixSuffixPairs(String[] words)
    {
       
        int ans=0;
        for(int i=0;i<words.length-1;i++){
            
             for(int j=i+1;j<words.length;j++){
             if(isPrefixAndSuffix(words[i], words [j])){
                ans+=1;
            }
          }
        }
        return ans;
        
    }
    public static boolean isPrefixAndSuffix (String word1 ,  String word2){
        int length1= word1.length();
        int length2= word2.length();
        if(length1>length2)return false;
        
        if(word2.substring(0 , length1).equals(word1) && word2.substring(length2 - length1).equals(word1))
        return true;
        else return false;
        
    }
}
//index of , will return the index of an element in the 

02.Using indexOf and lastIndexOf

  class Solution {
    public int countPrefixSuffixPairs(String[] words)
    {
       
        int ans=0;
        for(int i=0;i<words.length-1;i++){     
             for(int j=i+1;j<words.length;j++){
               String str1 = words[i];
               String str2 = words[j];

            if(str1.length()>str2.length())continue;
            if(str2.indexOf(str1)==0 && str2.lastIndexOf(str1) == str2.length()-str1.length() )ans+=1;
            }
        }
        return ans;
        
    }
}
//index of , will return the index of an element in the 
