package task8;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/21/12
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class OperationDivision implements Operation{

  /**
   * Divide one number to another
   * @param num1 the number that we are going to divide
   * @param num2 the number with which we divide
   * @return the result from the division
   */
  public int calculate(int num1, int num2) {
    return num1/num2;
  }
}
