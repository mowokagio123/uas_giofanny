package Service;


import dao.Mahasiswa_d;
import model.Mahasiswa;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * Created by Gio on 4/21/2017.
 */
public class Service_jdbc {

        private Mahasiswa_d mahasiswa;
        private Connection connection;

        public void setDataSource(DataSource dataSource){
            try {
                connection = dataSource.getConnection();
                mahasiswa = new Mahasiswa_d();
               mahasiswa.setConnection(connection);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        public Mahasiswa save(Mahasiswa mahasiswa_a) {
            try {
                connection.setAutoCommit(false);
                mahasiswa.save(mahasiswa_a);
                connection.commit();
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return mahasiswa_a;
        }

        public Mahasiswa update(Mahasiswa mahasiswa_a) {
            try {
                connection.setAutoCommit(false);
                mahasiswa.update(mahasiswa_a);
                connection.commit();
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return mahasiswa_a;
        }

        public Mahasiswa delete(Mahasiswa mahasiswa_a) {
            try {
                connection.setAutoCommit(false);
                mahasiswa.delete(mahasiswa_a);
                connection.commit();
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return mahasiswa_a;
        }

        public Mahasiswa getMahasiswa(int npm) {
            try {
                return mahasiswa.getByNpm(npm);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public List<Mahasiswa> getAllMahasiswa() {
            try {
                return mahasiswa.getAll();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }

}


