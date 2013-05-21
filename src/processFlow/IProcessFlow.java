package processFlow;

import java.util.Scanner;

/**
 * callback for the proccess flow of user infos and demands inputing.
 * @author koruk
 *
 */
public interface IProcessFlow {
    public void onInputDate(Scanner scanner, int numDays, int customerType);
}
