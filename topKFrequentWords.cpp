class Solution {
public:
    
     static bool sortbysec(pair<int,string> &a, pair<int,string> &b)
{
    if(a.first>b.first)
    {
        return true;
    }
    else if (a.first<b.first)
    {
        return false;
        
    }
         else
         {
            if(a.second<b.second)
            {
                
                return true;
}
             else{
                 
                 return false;
                 
             }
         }
         
         
}
    vector<string> topKFrequent(vector<string>& words, int k) {
        
        unordered_map<string, int> mp; //hashtable
        for(string word: words)
        {
            mp[word]++;      // mp['Joke']=3 mp['always']=2 //o(word.len)
            
        }
        
        priority_queue<pair<int, string>, vector<pair<int, string>>, greater<pair<int, string>> > pq;
        //vector<pair<int , string> > vec;
        for(auto it= mp.begin();it!=mp.end();it++)
        {
            //vec.push_back(make_pair(it->second, it->first));
            pq.push(make_pair(-(it->second), it->first));
        }
        vector<string> result;
        int ii=0;
        while(ii<k)
        {
            result.push_back(pq.top().second);
            pq.pop();
            ii++;
        } 
        return result;
        
        
    }
    
    //o(nlogk)
    

};
