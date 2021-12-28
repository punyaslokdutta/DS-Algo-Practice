// class LRUCache {
// public:
//     LRUCache(int capacity) {
        
//     }
    
//     int get(int key) {
        
//     }
    
//     void put(int key, int value) {
        
//     }
// };

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */

//LRUCache class
//LRUCache capacity(int cap)
//int get(key) -> returns key, if the key exists , otherwise return -1
//put(key , val)-> puts or update sthe value of the key in the cache 



// class LRUCache
// {
//     public:
//         list<pair<int,int>> l;
//         unordered_map<int,list<pair<int, int>>::iterator> m;
//         int size;
//         LRUCache(int capacity)
//         {
//             size=capacity;
//         }
//         int get(int key)
//         {
//             if(m.find(key)==m.end())
//                 return -1;
//             l.splice(l.begin(),l,m[key]);
//             return m[key]->second;
//         }
//         void put(int key, int value)
//         {
//             if(m.find(key)!=m.end())
//             {
//                 l.splice(l.begin(),l,m[key]);
//                 m[key]->second=value;
//                 return;
//             }
//             if(l.size()==size)
//             {
//                 auto d_key=l.back().first;
//                 l.pop_back();
//                 m.erase(d_key);
//             }
//             l.push_front({key,value});
//             m[key]=l.begin();
//         }
// };



class LRUCache {
public:
    unordered_map<int, pair<list<int>::iterator, int>> ht;
    list<int> dll;
    int cap;
    LRUCache(int capacity) {
        cap=capacity;
    }
    
    void moveToFirst(int key){
        dll.erase(ht[key].first);
        dll.push_front(key);
        ht[key].first=dll.begin();
    }
    
    int get(int key) {
        if(ht.find(key)==ht.end()) return -1;
        
        moveToFirst(key);
        return ht[key].second;
    }
    
    void put(int key, int value) {
        if(ht.find(key)!=ht.end()){
            ht[key].second=value;
            moveToFirst(key);
        }
        else{
            dll.push_front(key);
            ht[key]={dll.begin(), value};
            cap--;
        }
        
        if(cap<0){
            ht.erase(dll.back());
            dll.pop_back();
            cap++;
        }
        
    }
};

/*
Algorithm Outline:

LRUCache()
1. key -> (addr, value)
2. List, will contain keys
3. cap=capacity

Get
1. if found, movetofirst for key, return. Else -1

Put
1. if exist, update.
2. else add
3. move to first
4. if >capacity, remove last in list i.e. LRU

Move to first
1. erase element
2. add to first
3. store first addr in ht
 */
