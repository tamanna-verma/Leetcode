class Solution {
    public int hIndex(int[] citations)
    {
      //binary search , from  0 till max can be the answer 
      // ans <=n 
      // freq of paper that are cited ans times >=ans
      //we will sort the array 

      //sort the array 
      Arrays.sort(citations);
      int n = citations.length;
      if(n==1)return citations[0]==0? 0:1;
      int ans=n;
      int low=0;
      int high = n-1;
      while(low<=high)
      {
          int mid = (low+high)/2;
          if(citations[mid]==n-mid-1)
          {
           return citations[mid];
          }
          else if(citations[mid]<n-mid-1)
          {
           ans = n-mid-1;
           low=mid+1;
          }
          else
           { 
              high=mid-1;
          }
      }
      return ans;
      
    }
}
// 0 1 3 5 6 
   
