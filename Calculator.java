import java.awt.List;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author MAQUITO
 *
 */
public class Calculator  implements iCalculator{
	private int counter=0;
	private boolean broke=false;
	private Stack<Integer> temporalStack =new Stack<>();
	private ArrayList<String> validOperators =new ArrayList<>();
	public Calculator() {
		validOperators.add("+");
		validOperators.add("-");
		validOperators.add("/");
		validOperators.add("*");
		
	}
	@Override
	public void init() throws IOException, URISyntaxException {
		ArrayList <String> strings = (ArrayList<String>) Files.readAllLines(Path.of(Calculator.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()+"datos.txt"));
		// TODO Auto-generated method stub
		Stack<String> values = new Stack<>();
		for(String line : strings) {
			values.addAll(Arrays.asList(line.split(" ")));
			
		}
		for(int i=0;i<values.size();i++) {
			if(!isInt(values.get(i))) {
				managerOperator(values.get(i));
			}
			if(broke) {
				return;
			}
		}
		if (!broke && temporalStack.size()==1) {
			System.out.println("El resultado es " + temporalStack.pop());
		}else if(!broke) {
			System.out.println("No");
			
		}
				
	}
	public boolean isInt(String value) {
		try {
			int element = Integer.parseInt(value);
			temporalStack.push(element);
			return true;
			
		}catch (NumberFormatException e ) {
			return false;
		}
		// TODO Auto-generated method stub
		
	}
	public void manageOperator(String operator) {
		if(validOperators.contains(operator)) {
			if(temporalStack.size()>=2) {
				int b = temporalStack.pop();
				int a = temporalStack.pop();
				if(operator.equalsIgnoreCase("+")) {
					int sum = sum (b,a);
					temporalStack.push(sum);
				}else if (operator.equalsIgnoreCase("-")) {
					temporalStack.push(subtraction(a,b));
				}else if (operator.equalsIgnoreCase("/")) {
					temporalStack.push(division(a,b));
				}else {
					temporalStack.push(multiply(a,b));
				}
			}else {
				System.out.println("Ha ingresado un mas operadores de los validos");
				broke = true;
				
			}
		}else {
			System.out.println("Ha ingresado un valor invalido "+ operator);
			broke= true;
		}
	}
	

	@Override
	public int sum(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	
	@Override
	public int subtraction(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int division(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void managerOperator(String operator) {
		// TODO Auto-generated method stub
		
	}

	

}
