func findRightInterval(intervals [][]int) []int {
        
        // [3]int:
        //   0: interval[0]
        //   1: interval[1]
        //   2: interval's index in intervals
        //
        sorted := make([][3]int, len(intervals))[:0]
        
        for ik, i := range intervals {
                sorted = append(sorted, [3]int{i[0], i[1], ik})
        }
        
        sort.Slice(
                sorted,
                func(i, j int) bool { return sorted[i][0] < sorted[j][0] },
        )
        
        out := make([]int, len(intervals))
        
        for i := 0; i < len(sorted); i++ {
                found := sort.Search(
                        len(sorted),
                        func(j int) bool { return sorted[i][1] <= sorted[j][0] },
                )
                if found == len(sorted) {
                        out[sorted[i][2]] = -1
                } else {
                        out[sorted[i][2]] = sorted[found][2]
                }
        }
        
        return out
}