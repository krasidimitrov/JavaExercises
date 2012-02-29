package com.clouway.jspandservlet.onlinebookcatalog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Krasimir Dimitrov
 * Email: krasimir.dimitrov@clouway.com.
 * Date: 2/28/12
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Resources {
  private Map<String, PageChanger> pageChangersList = new HashMap<String, PageChanger>();

  public Resources(){
    pageChangersList.put("next",new ForwardPageChanger());
    pageChangersList.put("back",new BackwardPageChanger());
    pageChangersList.put("first",new FirstPageChanger());
    pageChangersList.put("last",new LastPageChanger());
  }

  public Map<String, PageChanger> getPageChangersList() {
    return pageChangersList;
  }
}
