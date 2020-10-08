import java.util.LinkedList;
import java.util.Queue;

/*******************Brute Force ( BFS) ****************************/
//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Broken_Calculator {
	public int brokenCalc(int X, int Y) {
		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		q.add(X);
		while(!q.isEmpty()){
			int size = q.size();
			for(int i=0; i<size; i++){
				int  curr = q.poll();
				if(curr == Y)   //if at any time the curr is Y then just return the count
					return count;
				if(curr > Y){
					q.add(curr -1);
				}
				else{
					//performing 2 operations on curr integer, multiply by 2 / decrement by 1
					q.add(curr * 2);
					q.add(curr - 1);
				}
			}
			count++;
		}
		return -1;
	}
}

/*******************Optimal ****************************/
//Time Complexity : O(log n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int brokenCalc(int X, int Y) {
        int count = 0;
        // X = 3, Y = 10
        // 10/2 => 5+1 => 6/2 => 3
        while(Y > X){
            if(Y % 2 == 0){ // if y is even
                Y = Y/2;
            } 
            else{   // if Y is odd
                Y = Y + 1;
            }
            count ++;
        }
        if(Y < X){  // at any time Y is less than X
            return count + X - Y;
        }
        return count;
    }
}