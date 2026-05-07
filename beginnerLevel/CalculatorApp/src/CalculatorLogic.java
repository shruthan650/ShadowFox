public class CalculatorLogic{
    private double num1 = 0;
    private String operator = "";
    private boolean operatorPressed = false;

    public String process(String input, String currentText) {
        try{
            if(input.matches("[0-9]")) {
                if(operatorPressed) {
                    currentText = "";
                    operatorPressed = false;
                }
                currentText += input;
            }

            else if(input.equals(".")) {
                if(!currentText.contains(".")) {
                    currentText += ".";
                }
            }

            else if(input.matches("[+*/-]")){
                num1 = Double.parseDouble(currentText);
                operator = input;
                operatorPressed = true;
            }

            else if(input.equals("=")) {
                double num2 = Double.parseDouble(currentText);
                double result = 0;

                switch(operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/":
                        if(num2 == 0) return "Error";
                        result = num1 / num2;
                        break;
                }

                operator = "";
                operatorPressed = true;

                return String.valueOf(result);
            }

            else if(input.equals("C")) {
                num1 = 0;
                operator = "";
                return "";
            }

            else if(input.equals("√")) {
                double val = Double.parseDouble(currentText);
                if(val < 0) return "Error";
                return String.valueOf(Math.sqrt(val));
            }

            else if(input.equals("x²")) {
                double val = Double.parseDouble(currentText);
                return String.valueOf(val * val);
            }

            else if(input.equals("%")) {
                double val = Double.parseDouble(currentText);
                return String.valueOf(val / 100);
            }

            return currentText;

        } catch(Exception e) {
            return "Error";
        }
    }
}