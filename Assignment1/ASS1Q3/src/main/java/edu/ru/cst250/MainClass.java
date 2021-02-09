package edu.ru.cst250;

public class MainClass {
        
public static int[] dropOddNumbers(int[] arr){

int count = 0;
for(int index = 0; index < arr.length; index++){
if(arr[index] % 2 == 0) {
count = count + 1;
    }
}
int[] resultArray = new int [count];
int resultArrayIndex = 0;

for(int index = 0; index < arr.length; index++){
if(arr[index] % 2 != 0){
continue;
}
resultArray [resultArrayIndex] = arr[index];
resultArrayIndex++;
}

return resultArray;

}
}
