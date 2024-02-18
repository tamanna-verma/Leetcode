
04.Greedy - Something that cant be solved using Greedy , we apply Recursion there

  class Solution {
    public boolean canJump(int[] nums)
    {
      int reachable =0;
      int n=nums.length;
      for(int i=0;i<nums.length;i++){
          if(reachable<i)return false;
          if(reachable>=n-1)return true;
          reachable = Math.max(reachable, i+nums[i]);
      }   
      return true;
    }
   
}
  

01.Recursion - gives TLE

  class Solution {
    public boolean canJump(int[] nums)
    {
        int n= nums.length;
        return helper(0 , nums);    
    }
    public boolean helper( int start ,int []nums)
        { 
          if(start>=nums.length-1 )return true;

          int jump  = nums[start];
          for(int i=1;i<=jump;i++){
             boolean temp = helper(start+i , nums);
             if(temp==true)return true;
          }
        return false;
        }
}
  
02.Memoization 

  class Solution {
    public boolean canJump(int[] nums)
    {
        int n= nums.length;
        int dp[] = new int [n];
     return   helper(0 , nums , dp)==1?true:false;
         
    }
    public int helper( int start ,int []nums , int dp[])
        { 
          if(start>=nums.length-1 )return 1;
          if(dp[start]!=0)return dp[start];
          int jump  = nums[start];
          for(int i=1;i<=jump;i++){
            int temp = helper(start+i , nums,dp);
             if(temp==1){ 
                 return dp[start]=1;
             }
          }
        
        return dp[start]=-1;
        }
}

03.Tabulation


  class Solution {
    public boolean canJump(int[] nums)
    {
        int n= nums.length;
        int dp[] = new int [n];

        
        dp[n-1]=1;
        for(int i= n-2;i>=0;i--){
           for(int j=1;j<=nums[i];j++){
           if( j + i >= n || dp[j+i]==1 ){
              dp[i]=1;
              break; 
           }
          }
        }
        for(int i=0;i<dp.length;i++){System.out.print(dp[i]+" ");}
        return dp[0]==1?true :false;    
    }
   
}

