class Solution {
    
    public int remove0 (String s)
    {
        int ret = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) -'0' == 1)
               ret++;
        }
        return ret;
    }
    public String make2(int x)
    {
        if(x == 1)
            return "1";
        StringBuffer sb = new StringBuffer();
        
        while(x > 0)
        {
            sb.append(x%2);
            x = x/2;
        }
        return sb.reverse().toString();
        
    }
    public int[] solution(String s) {
        int[] answer = new int[2];
        String temp = s;
        int res = 0;
        do{
            int lastLength = temp.length();
            res = remove0(temp);
            answer[1] += (lastLength - res);
            temp = make2(res);
            answer[0]++;
        }
        while(res > 1);
        return answer;
    }
}