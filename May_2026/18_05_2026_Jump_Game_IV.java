class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n==1) return 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(!map.containsKey(arr[i])) map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(n-1);
        vis[n-1]=true;
        int count=0, x;

        while(!q.isEmpty()) {
            int sz = q.size();
            count++;
            for(int k=0; k<sz; k++) {
                int ind = q.poll();
                
                x=ind-1;
                if(x==0) return count;
                if(x>=0 && x<n && !vis[x]) {vis[x]=true; q.add(x);}

                x=ind+1;
                if(x==0) return count;
                if(x>=0 && x<n && !vis[x]) {vis[x]=true; q.add(x);}

                List<Integer> list = map.get(arr[ind]);
                if(list!=null) {
                for(int i : list){
                    if(!vis[i]) {
                        if(i==0) return count;
                        vis[i]=true;
                        q.add(i);
                    }
                }
                }
                map.remove(arr[ind]);
            }
        }
        return -1;
    }
}
