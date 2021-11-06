public:
    bool judgeCircle(string moves) {
      int m=0;
      int n=0;
      for(auto it : moves)
      {
          if(it=='L')
          {
              m--;
          }
          else if (it=='R')
          {
              m++;
          }
          else if(it=='U')
          {
              n++;
          }
          else
          {
              n--;
          }
      }
        
    if(m==0 && n==0)
    {
        return true;
    }
        else
        {
            return false;
        }
    }
};
