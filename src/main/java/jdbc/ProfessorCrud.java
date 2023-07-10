package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorCrud {
    private Connection conexao;

    public ProfessorCrud() {
        conexao = Conexao.getConnection();
    }

    public void save(Professor professor) {
        try {
            String sql = "INSERT INTO tab_professor (nome, dataNascimento, cargaHoraria, valorHora,"
                    + " estrangeiro, horasDisponiveis, biografia, dataHoraCadastro)"
                    + " VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, professor.getNome());
            statement.setDate(2, Date.valueOf(professor.getDataNascimento()));
            statement.setTime(3, Time.valueOf(professor.getCargaHoraria()));
            statement.setDouble(4, professor.getValorHora());
            statement.setBoolean(5, professor.isEstrangeiro());
            statement.setInt(6, professor.getHorasDisponiveis());
            statement.setString(7, professor.getBiografia());
            statement.setTimestamp(8, Timestamp.valueOf(professor.getDataHoraCadastro()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Um(a) novo(a) professor(a) foi salvo(a) com sucesso!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(Professor professor) {
        try {
            String sql = "UPDATE tab_professor SET nome = ?, dataNascimento = ?, cargaHoraria = ?," +
                    " valorHora = ?, estrangeiro = ?, horasDisponiveis = ?, biografia = ?, dataHoraCadastro = ?" +
                    " WHERE id = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, professor.getNome());
            statement.setDate(2, Date.valueOf(professor.getDataNascimento()));
            statement.setTime(3, Time.valueOf(professor.getCargaHoraria()));
            statement.setDouble(4, professor.getValorHora());
            statement.setBoolean(5, professor.isEstrangeiro());
            statement.setInt(6, professor.getHorasDisponiveis());
            statement.setString(7, professor.getBiografia());
            statement.setTimestamp(8, Timestamp.valueOf(professor.getDataHoraCadastro()));
            statement.setInt(9, professor.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Alteração realizada com sucesso!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int delete(Integer id) {
        int rowsDeleted = 0;
        try {
            String sql = "DELETE FROM tab_professor WHERE id = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);
            rowsDeleted = statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rowsDeleted;

    }

    public Professor findById(Integer id) {
        Professor professor = null;
        try {
            String sql = "SELECT * FROM tab_professor WHERE id = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                professor = new Professor();
                professor.setId(result.getInt("id"));
                professor.setNome(result.getString("nome"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return professor;
    }

    public List<Professor> findAll() {
        List<Professor> registros = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tab_professor";
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Professor professor = new Professor();
                professor.setId(result.getInt("id"));
                professor.setNome(result.getString("nome"));
                registros.add(professor);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return registros;
    }

}
