
class Triple {
    List<Integer> combination;
    int sum, index;
    
    public Triple(List<Integer> combination, int index, int sum) {
        this.combination = combination;
        this.index = index;
        this.sum = sum;
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        Queue<Triple> combinationsQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        combinationsQueue.add(new Triple(new ArrayList<>(), 0, 0));
        
        while(!combinationsQueue.isEmpty()) {
            int size = combinationsQueue.size();
            for(int i = 0; i < size; i++) {
                Triple triple = combinationsQueue.poll();
                List<Integer> combination = triple.combination;
                int index = triple.index;
                int sum = triple.sum;
                
                for(int j = index; j < candidates.length; j++) {
                    if(sum + candidates[j] < target) {
                        List<Integer> newCombination = new ArrayList<>(combination);
                        newCombination.add(candidates[j]);
                        combinationsQueue.add(new Triple(newCombination, j, sum + candidates[j]));
                    } else if(sum + candidates[j] == target) {
                        List<Integer> newCombination = new ArrayList<>(combination);
                        newCombination.add(candidates[j]);
                        result.add(newCombination);
                    } else {
                        break;
                    }
                }
            }
        }
        
        return result;
    }
}