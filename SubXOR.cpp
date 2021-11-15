#include <stdio.h>

#define MAX 200000

struct node{
 int nL, nR;
 int leftIndex, rightIndex;

 node(){
  nL = 0;
  nR = 0;
  leftIndex=-1;
  rightIndex=-1;
 }
};
  
int gIndex=0;

void insert(int value, int index, int depth, node *tree){
 for(int i = depth-1;i>=0;--i){
  int bit = value>>i & 1;
  if(bit){
   tree[index].nR++; 
   if(tree[index].rightIndex==-1){ 
    tree[index].rightIndex = ++gIndex;
    index = gIndex;
   }else index = tree[index].rightIndex;
  }else{ 
   tree[index].nL++;
   if(tree[index].leftIndex==-1){
    tree[index].leftIndex = ++gIndex;
    index = gIndex;
   }else index = tree[index].leftIndex; 
  }
 } 
}

int query(int value, int compare, int index, int depth, node* tree){
 int ans=0;
 for(int i=depth-1;i>=0;--i){
  int vBit = value>>i & 1;
  int cBit = compare>>i & 1;
  if(cBit){ 
   if(vBit){ans += tree[index].nR; index = tree[index].leftIndex;}
   else{ans += tree[index].nL; index = tree[index].rightIndex;} 
  }else{ 
   if(vBit) index = tree[index].rightIndex;
   else  index = tree[index].leftIndex;
  }
  if(index==-1)break; 
 }
 return ans;
}

int main(){
 int d;
 scanf("%d", &d);
 while(d--){ 
  node tree[MAX];
  gIndex=0;
  int n, k;
  scanf(" %d %d", &n, &k);
  int XOR = 0, t=0;
  long long ans=0;
  insert(0, 0, 20, tree);
  while(n--){
   scanf(" %d", &t);
   XOR = XOR ^ t;
   ans += query(XOR, k, 0, 20, tree);  
   insert(XOR, 0, 20, tree);
  }
  printf("%lld\n", ans);
 }
}



// Given an array of positive integers you have to print the number of subarrays whose XOR is less than K. 
// Subarrays are defined as a sequence of continuous elements Ai, Ai+1, ..., Aj .
// XOR of a subarray is defined as Ai ^ Ai+1 ^ ... ^ Aj. Symbol ^ is Exclusive Or



// Let f(L,R) = XOR of subarray a[L…R], then f(L,R) = f(1,R) XOR f(1,L-1).
// For each index i=1 to N, we can count how many subarrays ending at ith position satisfy the given condition.
// Now, suppose, that we have a data structure that allows us to perform this two operations: insert some integer into this structure and for given two integers X and K finds the number of elements already in structure whose XOR with X is less than K.

// Then we can solve the task like this:

// Answer = 0;
// XorOnPrefix = 0;
// Structure.insert(0);
// for i = 1 to n
//     XorOnPrefix = XorOnPrefix xor a_i;
//     Structure.insert(XorOnPrefix);
//     Answer + = Structure.query(XorOnPrefix,k);
// return Answer;
// Now, about the data structure. It can be implemented as trie (prefix tree) 38, if we consider integers as binary strings of length logA = 20. Then insertion can be done in O(logA) time. But we also need to keep at each node the number of leaves we will encounter if we go to left side from that node and similarly for right.
// How do we do query(x,k)?

//  Structure.query(root,x,k,level)
//  {
//      if level==-1 or root==NULL: return 0
//      q=level'th bit of k
//      p=level'th bit of x
//      if q>0:
//          if p==0: // means that all leaves on left of this node will always satisfy 
//                  // + queries on right side
//                return root.count_left + Structure.query(root.right,x,k,level-1);
//          else:  // all leave on right of this node will always satisfy
//                 // + queries on left of this node
//                return root.count_right + Structure.query(root.left,x,k,level-1);
//      else:
//          if p==0: return Structure.query(root.left,x,k,level-1);
//          else: return Structure.query(root.right,x,k,level-1);
//  }
// SIMILAR PROBLEM:
// XORSUM ACM AMRITA’09 97

// 10^6 ~= 2^20 (20 bits to represent )





