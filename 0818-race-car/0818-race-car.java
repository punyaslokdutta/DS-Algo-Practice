class Solution {
    public int racecar(int target) {
        Queue<int[]> q= new LinkedList<>();
        Set<int[]> st = new HashSet<>();
        q.add(new int []{0, 1, 0});
        while(!q.isEmpty())
        {
            int []f = q.poll();
            int pos = f[0];
            int speed = f[1];
            int moves = f[2];
            //st.add(f);
            if(pos == target) return moves;
            
            if(st.contains(new int[]{pos, speed , moves})) continue;
            q.add(new int[]{pos + speed , 2*speed , moves + 1}); //A
            if((pos + speed > target && speed >0) || (pos + speed < target && speed < 0))
            {
                //R
                q.add(new int[]{pos, speed > 0 ? -1 : 1 , moves + 1 });
            }
            
        }
        return 0;
        
    }
}



//  (pos, speed, moves) 
//  (0, 1, A) -> (1, 2, A) 
//  (0, 1, R) ->(1, -1 , A) || (1, -1, R)
//  2^n 
//  dp(pos) = min(dp(pos), inst.length());
// to reach pos -> dp[pos] is the minimum iinstructoion 

// AAAARA

// BFS / DP


// 2^n  , 

// (pos, speed, inst)
// {
//     if(pos == target)
//          return inst.length();
//     if(pos > target)
//     {
//         next -> R
//     }
//     else if(pos < target && speed < 0 )
//         R
//     else if(pos < target && dpeed >0)
//         A
//     else{
//         //2 paths
//     }
//     if(inst == 'A')
//     {
//         pos+=speed ;
//         speed*=speed;
//     }
    
//     if(inst == 'B')
//     {
        
//     }
// }
//   if(pos + speed > target && speed < 0)
//     q.add('A')
// if((pos + speed > target && speed > 0) || pos + speed < target && speed < 0)
//     q.add('R')





