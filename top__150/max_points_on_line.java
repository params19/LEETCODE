package top__150;
// class Solution {
//     public int maxPoints(int[][] points) {
        // int n=points.length;
        // if(n==1)
        // return 1;
        // int res=0;

        // for(int i=0;i<n;i++)//Point 1(x1,y1)
        // {
        //     for(int j=i+1;j<n;j++)//Point 2(x2,y2)
        //     {
        //         int cnt=2;
        //         int dx=points[j][0]-points[i][0];//(x2-x1)
        //         int dy=points[j][1]-points[i][1];//(y2-y1)

        //         for(int k=0;k<n;k++)
        //         {
        //             if(k!=i && k!=j)
        //             {
        //             int dx1=points[k][0]-points[i][0];//(xk-x1)
        //             int dy1=points[k][1]-points[i][1];//(yk-y1)

        //             if(dx*dy1==dy*dx1)//(x2-x1)*(yk-y1)==(y2-y1)*(xk-x1)
        //             {
        //                 cnt++;
        //             }
        //         }
        //     }
        //         res=Math.max(res,cnt);
        //     }
        // }
        // return res;
//     }
// }

import java.util.Collections;
import java.util.HashMap;

class Solution {
            public int maxPoints(int[][] points) {
                int n = points.length;
                if (n <= 2) 
                {
                    return n;
                }

                int ans = 2;
                for (int i = 0; i < n; i++) 
                {
                    HashMap<Double, Integer> map = new HashMap<>();
                    for (int j = 0; j < n; j++) 
                    {
                        if (i != j) 
                        {
                            int dy = points[j][1] - points[i][1];
                            int dx = points[j][0] - points[i][0];
                            double angle = Math.atan2(dy, dx);
                            map.put(angle, map.getOrDefault(angle, 0) + 1);
                        }
                    }
                    ans = Math.max(ans, Collections.max(map.values()) + 1);
                }
                return ans;
            }
        }
  