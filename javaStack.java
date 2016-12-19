package hackerrank;

import java.util.*;
public class javaStack{
   
	private static Map<Character,Character> validCharacters=populateMap();
	
	
	public static Map<Character,Character> populateMap(){
		
		Map<Character,Character> map=new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{','}');
		return map;
	}
	
	public static boolean validation(String str){
		
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(validCharacters.containsKey(c)){
				stack.push(c);
			}
				else if(validCharacters.containsValue(c) && !stack.isEmpty()){
					char closeParam=validCharacters.get(stack.pop());
					if(c!=closeParam)
					{
						return false;
					}
				}
				else {
					return false;
				}
			}		
		return stack.isEmpty();
	}

   public static void main(String []args)
   {
      Scanner sc = new Scanner(System.in);
      while (sc.hasNext()) {
         String input=sc.next();
         System.out.println(validation(input));
      }
      
   }
}