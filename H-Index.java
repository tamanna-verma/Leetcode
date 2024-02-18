class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int h_index = 0;
        // Sorting the array
        Arrays.sort(citations);
        // Finding the citations[i] say t such that the remaining papers have atleast t citations
        for (int i=0; i<citations.length; i++) {
            if (citations[i] >= n-i) {
                h_index = Math.max(n-i, h_index);
                break;
            }
        }
        return h_index;
    }
}