func maxCoins(nums []int) int {
    arr := make([]int, len(nums)+2)
    n := 1
    for _, x := range nums {
        if x > 0 {
            arr[n] = x
            n++
        }
    }
    arr[0] = 1
    arr[n] = 1
    n++
    dp := make([][]int, n)
    for i := range dp {
        dp[i] = make([]int, n)
    }
    return solve(dp, arr, 0, n-1)
}

func solve(dp [][]int, arr []int, left int, right int) int {
    if left+1 >= right {
        return 0
    }
    if dp[left][right] > 0 {
        return dp[left][right]
    }
    ans := 0
    for i := left + 1; i < right; i++ {
        ans = max(ans, arr[i]*arr[left]*arr[right]+solve(dp, arr, left, i)+solve(dp, arr, i, right))
    }
    dp[left][right] = ans
    return ans
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
