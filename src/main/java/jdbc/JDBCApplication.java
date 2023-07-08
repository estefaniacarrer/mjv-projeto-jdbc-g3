package jdbc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class JDBCApplication {
    private static ProfessorCrud professorCrud;
    public static void main(String[] args) {
        Conexao.iniciarConexao();
        professorCrud = new ProfessorCrud();
        incluirProfessor();
//        alterarProfessor();
//        listarProfessor();
//        excluirProfessor();
    }

    private static void incluirProfessor(){
        Professor professor  = new Professor();
        professor.setNome("Kelly");
        professor.setDataNascimento(LocalDate.of(1995, 2, 22));
        professor.setCargaHoraria(LocalTime.of(8,0,0));
        professor.setValorHora(85.0);
        professor.setEstrangeiro(true);
        professor.setHorasDisponiveis(20);
        professor.setBiografia("Professora apaixonada por ensinar e inspirar alunos a alcançarem seu pleno potencial acadêmico e pessoal.");
        professor.setDataHoraCadastro(LocalDateTime.now());
        professorCrud.save(professor);
    }
//    private static void alterarProfessor(){
//        Professor professor  = professorCrud.findById(1);
//        if(professor!=null){
//            professor.setCargaHoraria(LocalTime.of(10,0,0));
//            professor.setValorHora(65.0);
//            professor.setHorasDisponiveis(10);
//            professorCrud.update(professor);
//        }else {
//            System.out.println("Não existe o professor com o id informado.");
//        }
//    }
//    private static void listarProfessor(){
//        List<Professor> professores = professorCrud.findAll();
//        for(Professor p:professores){
//            System.out.println(p.getId() + "--" + p.getNome());
//        }
//    }
//    private static void excluirProfessor(){
//        int linhasDeletas = professorCrud.delete(1);
//        if(linhasDeletas==0)
//            System.out.println("Nenhum registro com id informado localizado para a exclusão");
//    }
}
