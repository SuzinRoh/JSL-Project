
public class dd {

	public static long[] solution(int x, int n) {
       
		long[] answer = new long[n];
        for(int i=0; i<n; i++){
            answer[i] = x*(i+1);
            System.out.println(answer[i]);
            
           
        }
        return answer;
    }
    
     public static void main(String[] args){
    
       int x = 2;
       int n = 5;
         
     
        solution(x,n);
      
      
    }

}
