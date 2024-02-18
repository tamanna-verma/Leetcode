03.TABULATION
  
class Solution {
    public int jump(int[] nums)
    {
        int n= nums.length;
        int dp[] = new int [n];

        
        dp[n-1]=1;
       
        for(int i= n-2;i>=0;i--){
           int min=Integer.MAX_VALUE;
           for(int j=1;j<=nums[i];j++){
           if( j + i >= n-1)
           {
               min=1;
               break;
           }
           else if (dp[j+i]!=0){
               min=Math.min(min, dp[j+i]);
           }
          }
          dp[i] = min>=Integer.MAX_VALUE?0:min+1;
        }
        for(int i=0;i<dp.length;i++){System.out.print(dp[i]+" ");}
        return dp[0]-1; 
    }
}
