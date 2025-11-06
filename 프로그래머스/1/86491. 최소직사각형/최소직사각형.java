import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i = 0; i < sizes.length; i++)
        {
            int[] size = sizes[i];
            int temp = 0;
            if(size[0] < size[1])
            {
                temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
        }
        int x_max = 0;
        int y_max = 0;
        for(int i = 0; i < sizes.length; i++)
        {
            x_max = Math.max(x_max, sizes[i][0]);
            y_max = Math.max(y_max, sizes[i][1]);
        }
        return x_max * y_max;
    }
}