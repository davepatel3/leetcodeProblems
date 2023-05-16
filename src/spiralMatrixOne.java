import java.util.ArrayList;
import java.util.List;
class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int currentIteration = 0;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        spiral: {   //block that encloses all inner loops to allow for nested breaks
            while (nums.size() < matrix.length * matrix[0].length) {  //keeps alternating direction until 
                for(int i = currentIteration; i < matrix[0].length - currentIteration; i++) {
                    nums.add(matrix[currentIteration][i]); //adds going right
                    if(nums.size() == matrix.length * matrix[0].length) {
                        break spiral;
                    }
                }

                for(int j = currentIteration + 1; j < matrix.length - currentIteration; j++) {  //+1 means no recounting
                    nums.add(matrix[j][matrix[0].length - 1 - currentIteration]);
                    if(nums.size() == matrix.length * matrix[0].length) {
                        break spiral;
                    }
                }

                for(int k = matrix[0].length - 2 - currentIteration; k >= currentIteration; k--) {
                    nums.add(matrix[matrix.length - 1 - currentIteration][k]);
                    if(nums.size() == matrix.length * matrix[0].length) {
                        break spiral;
                    }
                }

                for(int l = matrix.length - 2 - currentIteration; l >= currentIteration + 1; l--) {
                    nums.add(matrix[l][currentIteration]);
                    if(nums.size() == matrix.length * matrix[0].length) {
                        break spiral;
                    }
                }
                currentIteration++;
            }
        }
        return nums;
    }
}