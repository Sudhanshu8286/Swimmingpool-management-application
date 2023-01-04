package CoreJavaProject;

import java.sql.SQLException;

public class SwimmingPoolManagment {

	public static void main(String[] args) {
		try {
			DatabaseInterface.dbConnect();
			UIInterface.startApp();
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		

	}

}
