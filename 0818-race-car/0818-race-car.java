class Solution {
   List<Integer[]> queue = new ArrayList<Integer[]>(); 
   // HashSet<Integer[]> visited = new HashSet<Integer[]>(); 
   int moves, position, speed = 0;
    public int racecar(int target) {
          queue.add(new Integer[]{0,0,1}); // #moves, position, speed
          
          while(queue.size() > 0) {
              moves = queue.get(0)[0];
              position = queue.get(0)[1];
              speed = queue.get(0)[2];
              queue.remove(0);
              
              if (position == target) {
                  return moves;
              }
              else {
              //visited.add(new Integer[]{position, speed});
                  queue.add(new Integer[]{moves+1,position+speed,speed*2 });
                  if ((position+speed > target && speed > 0) || (position+speed < target && speed < 0)) {
					  queue.add(new Integer[]{moves+1,position, speed > 0? -1: 1 });
                  }
              }
          }
        return moves;
    }
}