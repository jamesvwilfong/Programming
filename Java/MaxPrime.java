public static void largestPrimeFactor() {
   long max = 0;
   for(long j = 1; j<600851475143;j++){
      for(long i = 2; i<j; i++) {
         if(i == j-1 && j>max) 
            max = j;   
      }
   }
}
