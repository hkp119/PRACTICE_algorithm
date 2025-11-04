#include <string>
#include <vector>
#include <algorithm>
using namespace std;

long long solution(int n, vector<int> times) {
    if(times.empty()) return 0;
    sort(times.begin(), times.end()); // 오름차순 정렬
    
    unsigned long long answer = 0;
    unsigned long long left = 1;
    unsigned long long right = times[times.size()-1] * n; // 최대 시간
    
    unsigned long long mid = 0;

    while(left <= right)
    {
        mid = (left + right)/2;
        unsigned long long total = 0;
        for(int i = 0; i < times.size(); i++)
            total += mid / times[i];  
        
        if(total >= n)
        {
            answer = mid;
            right = mid - 1;
        }
        else
        {
            left = mid + 1;
        }
    }
    
    return answer;
}