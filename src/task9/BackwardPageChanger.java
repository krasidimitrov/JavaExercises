package task9;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/28/12
 * Time: 1:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class BackwardPageChanger implements PageChanger{

  public int change(int position) {
  if(position==0){
    return 0;
  }
    return position-3;
  }
}
