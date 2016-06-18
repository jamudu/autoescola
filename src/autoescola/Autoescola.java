//

package autoescola;

import dao.AlumneJDBC;
import dao.CarnetJDBC;
import dao.MatriculaJDBC;
import dao.ProfessorJDBC;
import dao.VehicleJDBC;
import vista.Menu;

/**
 *
 * @author usu21
 */
public class Autoescola {
    
    public static AlumneJDBC alumneJDBC;
    public static ProfessorJDBC professorJDBC;
    public static VehicleJDBC vehicleJDBC;
    public static CarnetJDBC carnetJDBC;
    public static MatriculaJDBC matriculaJDBC;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu mp= new Menu();
        mp.setLocationRelativeTo(mp);
        mp.setVisible(true);
    }
    
}
