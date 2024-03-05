package Utilities;

import java.util.UUID;

public class Baseclass {
	  protected String username = "soh" + UUID.randomUUID().toString().substring(0, 5);
      protected String email = "soha" + UUID.randomUUID().toString().substring(0, 5) + "@gmail.com";
	protected String companyName ="soh"+ UUID.randomUUID().toString().substring(0, 5).replaceAll("\\s+", "");;

}

