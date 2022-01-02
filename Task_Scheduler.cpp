
// //lastTask 
// //map['task'] , it's better to execute the task with greater count
// //Given that , index[lastTask]+ cooldown+1 <=idx, then we can map['task']-- 



//FASTEST
//40 ms
class Solution {
public:
    int max(int x, int y)
    {
        return (x>y)?x:y;
    }
    int cnt[26], maxcnt = 0, e = 0;
    int leastInterval(vector<char>& tasks, int n) {
        for (char c : tasks) cnt[c-'A']++;
        for (int i = 0; i < 26; i++) maxcnt = max(maxcnt, cnt[i]);
        for (int i = 0; i < 26; i++) 
            if (cnt[i] == maxcnt) e++;
        return max(tasks.size(), (maxcnt-1)*(n+1) + e);
    }
};


// //mp['A']=3;
// //mp['B']=3
//100ms
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        map<char,int> mp;
        for(auto task: tasks)
        {
            mp[task]++;
        }
        int cycles=0;
        priority_queue<int> pq;
        for(auto i:mp)
        {
            pq.push(i.second);
        }
        
        while(!pq.empty())
        {
            vector<int>temp;
            for(int i=0;i<=n;i++)
            {
                if(!pq.empty())
                {
                    temp.push_back(pq.top());
                    pq.pop();
                }
                else if(pq.empty())
                    break;
            }
            
            for(auto t: temp)
            {
                if(--t>0)
                {
                    pq.push(t);
                }
            }
            
            cycles+=(pq.empty())?temp.size(): n+1;
            
        }
        return cycles;
    }
// //         int leastInterval(vector<char>& tasks, int n) {
// //         unordered_map<char,int> m;
// //         for(auto c : tasks)
// //             m[c]++;
// //         priority_queue<int>pq;
// //         for(auto a:m)
// //             pq.push(a.second);
        
// //         n++;
// //         int c =0;
// //         while(pq.size() > 0){
// //             int k = min (n, (int)pq.size());
// //             vector<int>tmp;
// //             for(int i = 0; i < k; i++){
// //                 int f = pq.top();
// //                 f--;
// //                 pq.pop();
// //                 if(f!= 0) tmp.push_back(f);
// //             }
// //             if(tmp.size() >0)
// //                 c += n;
// //             else{
// //                 c += k;
// //             }
// //             for(auto x: tmp){
// //                 pq.push(x);
// //             }
// //         }
// //         return c;
// //         }
    
//     int leastInterval(vector<char>& tasks, int n) {
// 	int counts[26] = { 0 };
// 	int max = 0;
// 	int numMax = 0;
// 	for (char &task : tasks) {
// 		counts[task - 'A']++;
// 		if (counts[task - 'A'] > max) {
// 			max = counts[task - 'A'];
// 			numMax = 1;
// 		} else if (counts[task - 'A'] == max) {
// 			numMax++;
// 		}
// 	}

// 	// check to see if there's enough task to fill up the idles
// 	if (tasks.size() - max > n * (max - 1)) {
// 		return tasks.size();
// 	}
// 	return max + n * (max - 1) + numMax-1 ;
// }
//     // int leastInterval(vector<char>& tasks, int n) 
//     // {
//     //     int i,j=0,k,cnt=0;
//     //     int a[26];
//     //     for(i=0;i<26;i++)
//     //     {
//     //         a[i]=0;
//     //     }
//     //     for(i=0;i<tasks.size();i++)
//     //     {
//     //         a[(tasks[i]-'A')]++;
//     //     }
//     //     for(i=0;i<26;i++)
//     //     {
//     //         if(j<a[i])
//     //         {
//     //             j=a[i];
//     //             cnt=1;
//     //         }
//     //         else if(j==a[i])
//     //         {
//     //             cnt++;
//     //         }
//     //     }
//     //     k=(j-1)*(n+1)+cnt;
//     //     if(k<tasks.size())
//     //     {
//     //         k=tasks.size();
//     //     }
//     //     return k;
//     // }
    
// };

// class Solution {
// public:
//     int leastInterval(vector<char>& tasks, int n) {
//         if(n==0) 
//             return tasks.size();
//         int freq[26] = {0};
//         for(char c: tasks) 
//             freq[c-'A']++;
//         sort(freq,freq+26);
//         int max_val = freq[25]-1; //don't need to wait at the end
//         //max_val indicates the number of times the task with maximum frequency has to cool
//         int idle_slots = max_val*n; 
//         //try to do other tasks in the idle positions 
//         for(int i=24;i>=0;i--) {
//             idle_slots -= min(freq[i],max_val);    
// //because there can be others slot with same maximum frequency and in that case, it's not possible to accomodate them all that within the idle slots (as in case1 ["A","A","A","B","B","B"])
//             cout<< min(freq[i],max_val)<<" " ;
//         }
//         return (idle_slots>0)?tasks.size()+idle_slots : tasks.size();
//     }
// };

