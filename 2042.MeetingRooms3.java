class Pair{
    int first;
    int second;
    Pair(int first , int second)
    {
        this.first = first;
        this.second= second;
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        //they are already sorted on basis of their start time , we need to have 2 meeting rooms 
        Arrays.sort(meetings , new compareStartTime());
        PriorityQueue<Pair> pq = new PriorityQueue<>(new comparePairs());
        PriorityQueue<Pair> freerooms = new PriorityQueue<>( new compareFreeRooms ());
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i=0;i<meetings.length ;i++)
        {
           int []meet = meetings[i];
           int start = meet[0];
           int end = meet[1];
           int pqsize = pq.size();

               while(pq.size()>0 && pq.peek().first<=start)
               {
                 
                 Pair removed =  pq.remove();
                 freerooms.add(removed);//abi free rooms to milgye 
               }
              
              if(freerooms.size()>0)
               {
                Pair removed = freerooms.remove();
                pq.add(new Pair(end,removed.second));
                int freq = map.getOrDefault(removed.second , 0);
                map.put(removed.second , freq+1);
               }
               else if(pq.size()>0 && pq.size()==n) //if no free room
               {   //if need to wait because pq size ==n-1
                Pair removed =  pq.remove();
                 System.out.println(removed.first +" " +removed.second);
                pq.add(new Pair((end-start)+removed.first,removed.second));
                int freq = map.getOrDefault(removed.second , 0);
                map.put(removed.second , freq+1);
               }
               else if(pqsize==0 || pqsize<n){
                    pq.add(new Pair(end , pqsize));
                     map.put(pqsize, 1);
               }
            }
           

    
       var entryset = map.entrySet();
        
        int maxfreq=-1;
        int number =-1;
       for(var entry : entryset)
       {
           int key = entry.getKey();
           int val = entry.getValue();
        //    System.out.println(key +" "+ val);

           if(val>maxfreq){
               number= key;
               maxfreq = val;
           }


       }
       return number;

    }
    
}

class comparePairs implements Comparator<Pair>{
    public int compare(Pair a ,Pair b )
    {
        if(a.first==b.first)return a.second - b.second;//> sign means whichever is smaller return that
        else return a.first - b.first;
    }
}

class compareFreeRooms implements Comparator<Pair>{
    public int compare(Pair a ,Pair b )
    {
      return a.second - b.second;//> sign means whichever is smaller return that
    }
}

class compareStartTime implements Comparator<int []>{
    public int compare(int [] a ,int []b )
    {
      return a[0] - b[0];//> sign means whichever is smaller return that
    }
}
//buold a comparator 
// put the pairs in the pq  
      //
