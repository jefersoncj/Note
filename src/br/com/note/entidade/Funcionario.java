/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.note.entidade;

/**
 *
 * @author f82cpd01
 */
public class Funcionario {
    private String matricula; 
    private String nome; 
    private Integer setor; 
    private Integer funcao;
    
    public Funcionario() {
		super();
	}

    public Funcionario(String matricula, String nome, Integer setor, Integer funcao) {
        this.matricula = matricula;
        this.nome = nome;
        this.setor = setor;
        this.funcao = funcao;
    }
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSetor() {
        return setor;
    }

    public void setSetor(Integer setor) {
        this.setor = setor;
    }

    public Integer getFuncao() {
        return funcao;
    }

    public void setFuncao(Integer funcao) {
        this.funcao = funcao;
    }

  
}
