class Solution {
    vector<vector<int>>offers;
    vector<int>price;
public:
    int n;
    int offersSize=0;
    int minCost(int index, vector<int>needs)
    {
        if(index==offersSize)
        {
            int cost=0;
            for(int i=0;i<n;i++)
            {
                cost+= price[i]*needs[i];
            }
            
            return cost;
        }
        
        vector<int>currOffer=offers[index];
        int currOfferPrice=currOffer[n];
        int ans=INT_MAX;
        //TAKE THE OFFER 
        vector<int>newNeeds(needs);
        bool canUse=true;
        for(int k=0;k<n;k++)
        {
            
            newNeeds[k]-=currOffer[k];
            if(newNeeds[k]<0)
            {
                canUse=false;
            }
        }
        if(canUse)
            ans=currOfferPrice + minCost(index, newNeeds); //A OFFER CAN BE USED MULTIPLE TIMES
        
        //NOT TAKE THE OFFER 
        ans= min(ans, minCost(index+1, needs));
        
        return ans;
    }
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        offersSize=special.size();
        n=price.size();
        offers=special;
        this->price=price;
        return minCost(0, needs);        
    }
};
