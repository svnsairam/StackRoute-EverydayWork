package com.stackroute.javaPe2;

public class Q6_StudentsAndGrades {


    public double averageGrade(int input, int[] grades){ //method to calculate average grade
        //double sum;
        double averagegGrade=0 ;
        double input1=input;

        for(int i=0;i<input;i++)
        {

            averagegGrade=averagegGrade+grades[i]/input1;
        }


        return averagegGrade;
    }

    public int minimumGrade(int input, int[] grades){ //method to calculate  minimumm grade

        int minimumGrade=grades[0];

        for(int i=0;i<input-1;i++)
        {
            if(minimumGrade>grades[i+1])
            {
                minimumGrade=grades[i+1];
            }
        }
        return minimumGrade;

    }

    public int maximumGrade(int input, int[] grades){  //method to calculate maximum grade

        int maximuGrade=grades[0];
        for(int i=0;i<input-1;i++)
        {
            if(maximuGrade<grades[i+1])
            {
                maximuGrade=grades[i+1];
            }
        }

        return maximuGrade;


    }

}
