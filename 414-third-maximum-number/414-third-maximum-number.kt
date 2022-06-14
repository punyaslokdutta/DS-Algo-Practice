class Solution {
    fun thirdMax(nums: IntArray): Int {
        val set = TreeSet<Int>()
        for(i in 0..nums.lastIndex)
        {
            set.add(nums[i])
        }
       return set.elementAtOrElse(set.size - 3) {
        set.elementAt(set.size - 1) // return max
    }
    }
}