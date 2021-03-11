import java.util.ArrayList;
import java.util.Collections;

public class Rivers {
    public static void main(String[] args){
        ArrayList<Integer> result1;
        ArrayList<Integer> result2;
        ArrayList<Integer> result3;
        int[][] riversLength1 = {{1,0,0,1}, {0,0,1,0}, {1,0,1,0}, {1,0,1,0}};
        int[][] riversLength2 = {{0,0,0,1,0,0,0,1}, {1,1,0,0,0,0,1,0}, {0,0,0,0,1,1,0,1}, {1,1,1,0,0,0,0,0}};
        int[][] riversLength3 = {{0,0,0,0,1}, {0,1,1,1,0}, {0,1,0,1,0}, {0,1,1,1,0},{1,0,0,0,0}};

        result1 = SortedRiversLength(riversLength1);
        result2 = SortedRiversLength(riversLength2);
        result3 = SortedRiversLength(riversLength3);

        for(Integer length : result1) {
            System.out.print(length);
        }
        System.out.println();
        for(Integer length : result2) {
            System.out.print(length);
        }
        System.out.println();
        for(Integer length : result3) {
            System.out.print(length);
        }
        System.out.println();
    }

    public static ArrayList<Integer> SortedRiversLength(int[][] riversLength)
    {
        ArrayList<Integer> lengths = new ArrayList<Integer>();
        int counter=0;

        for (int i = 0; i < riversLength.length; i++)
        {
            for (int j = 0; j < riversLength[i].length; j++)
            {
                if(riversLength[i][j] == 1)
                {
                    counter++;
                    riversLength[i][j]=0;
                    //check vertical
                    int row=i+1;
                    while(row<riversLength.length && riversLength[row][j]==1)
                    {
                        counter++;
                        riversLength[row][j]=0;
                        row++;
                    }
                    //check horizontal
                    int col=j+1;
                    while(col<riversLength[i].length && riversLength[i][col]==1)
                    {
                        counter++;
                        riversLength[i][col]=0;
                        col++;
                    }
                    lengths.add(counter);
                    counter=0;
                }
            }
        }
        Collections.sort(lengths);
        return lengths;
    }
}
